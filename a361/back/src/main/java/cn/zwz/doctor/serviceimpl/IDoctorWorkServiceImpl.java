package cn.zwz.doctor.serviceimpl;

import cn.zwz.doctor.mapper.DoctorWorkMapper;
import cn.zwz.doctor.entity.DoctorWork;
import cn.zwz.doctor.service.IDoctorWorkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 接诊 服务层接口实现
 * @author
 *
 */
@Slf4j
@Service
@Transactional
public class IDoctorWorkServiceImpl extends ServiceImpl<DoctorWorkMapper, DoctorWork> implements IDoctorWorkService {

    @Autowired
    private DoctorWorkMapper doctorWorkMapper;
}