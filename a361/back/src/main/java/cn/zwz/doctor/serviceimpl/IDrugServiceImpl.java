package cn.zwz.doctor.serviceimpl;

import cn.zwz.doctor.mapper.DrugMapper;
import cn.zwz.doctor.entity.Drug;
import cn.zwz.doctor.service.IDrugService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 药品 服务层接口实现
 * @author 
 * 
 */
@Slf4j
@Service
@Transactional
public class IDrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements IDrugService {

    @Autowired
    private DrugMapper drugMapper;
}