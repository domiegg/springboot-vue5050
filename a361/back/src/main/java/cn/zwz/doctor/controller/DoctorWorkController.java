package cn.zwz.doctor.controller;

import cn.zwz.basics.utils.PageUtil;
import cn.zwz.basics.utils.ResultUtil;
import cn.zwz.basics.baseVo.PageVo;
import cn.zwz.basics.baseVo.Result;
import cn.zwz.data.utils.ZwzNullUtils;
import cn.zwz.doctor.entity.DoctorWork;
import cn.zwz.doctor.service.IDoctorWorkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 
 * 
 */
@Slf4j
@RestController
@Api(tags = "接诊管理接口")
@RequestMapping("/zwz/doctorWork")
@Transactional
public class DoctorWorkController {

    @Autowired
    private IDoctorWorkService iDoctorWorkService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条接诊")
    public Result<DoctorWork> get(@RequestParam String id){
        return new ResultUtil<DoctorWork>().setData(iDoctorWorkService.getById(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部接诊个数")
    public Result<Long> getCount(){
        return new ResultUtil<Long>().setData(iDoctorWorkService.count());
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部接诊")
    public Result<List<DoctorWork>> getAll(){
        return new ResultUtil<List<DoctorWork>>().setData(iDoctorWorkService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询接诊")
    public Result<IPage<DoctorWork>> getByPage(@ModelAttribute DoctorWork doctorWork ,@ModelAttribute PageVo page){
        QueryWrapper<DoctorWork> qw = new QueryWrapper<>();
        if(!ZwzNullUtils.isNull(doctorWork.getTitle())) {
            qw.like("title",doctorWork.getTitle());
        }
        IPage<DoctorWork> data = iDoctorWorkService.page(PageUtil.initMpPage(page),qw);
        return new ResultUtil<IPage<DoctorWork>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改接诊")
    public Result<DoctorWork> saveOrUpdate(DoctorWork doctorWork){
        if(iDoctorWorkService.saveOrUpdate(doctorWork)){
            return new ResultUtil<DoctorWork>().setData(doctorWork);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增接诊")
    public Result<DoctorWork> insert(DoctorWork doctorWork){
        iDoctorWorkService.saveOrUpdate(doctorWork);
        return new ResultUtil<DoctorWork>().setData(doctorWork);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑接诊")
    public Result<DoctorWork> update(DoctorWork doctorWork){
        iDoctorWorkService.saveOrUpdate(doctorWork);
        return new ResultUtil<DoctorWork>().setData(doctorWork);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除接诊")
    public Result<Object> delByIds(@RequestParam String[] ids){
        for(String id : ids){
            iDoctorWorkService.removeById(id);
        }
        return ResultUtil.success();
    }
}
