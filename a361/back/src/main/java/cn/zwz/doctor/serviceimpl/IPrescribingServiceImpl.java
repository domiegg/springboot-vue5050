package cn.zwz.doctor.serviceimpl;

import cn.zwz.doctor.mapper.PrescribingMapper;
import cn.zwz.doctor.entity.Prescribing;
import cn.zwz.doctor.service.IPrescribingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 开处方 服务层接口实现
 * @author
 *
 */
@Slf4j
@Service
@Transactional
public class IPrescribingServiceImpl extends ServiceImpl<PrescribingMapper, Prescribing> implements IPrescribingService {

    @Autowired
    private PrescribingMapper prescribingMapper;
}