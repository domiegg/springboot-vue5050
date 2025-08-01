package cn.zwz.basics.security;

import cn.zwz.data.entity.User;
import cn.zwz.data.service.IUserService;
import cn.zwz.data.utils.ZwzNullUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 
 * 
 */
@ApiOperation(value = "登录判断类")
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private IUserService iUserService;

    private static final String LOGIN_FAIL_DISABLED_PRE = "userLoginDisableFlag:";

    @Override
    @ApiOperation(value = "根据账号/手机号查询用户所有信息")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String loginFailFlag = LOGIN_FAIL_DISABLED_PRE + username;
        String value = redisTemplate.opsForValue().get(loginFailFlag);
        Long timeRest = redisTemplate.getExpire(loginFailFlag, TimeUnit.MINUTES);
        if(!ZwzNullUtils.isNull(value)){
            throw new UsernameNotFoundException("试错超限，请您在" + timeRest + "分钟后再登");
        }
        QueryWrapper<User> userQw = new QueryWrapper<>();
        userQw.and(wrapper -> wrapper.eq("username", username).or().eq("mobile",username));
        userQw.orderByDesc("create_time");
        userQw.last("limit 1");
        User superUser = iUserService.getOne(userQw);
        if(superUser == null) {
            throw new UsernameNotFoundException(username + "不存在");
        }
        return new SecurityUserDetails(superUser);
    }
}
