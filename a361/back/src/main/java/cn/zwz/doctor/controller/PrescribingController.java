package cn.zwz.doctor.controller;

import cn.zwz.basics.utils.PageUtil;
import cn.zwz.basics.utils.ResultUtil;
import cn.zwz.basics.baseVo.PageVo;
import cn.zwz.basics.baseVo.Result;
import cn.zwz.data.utils.ZwzNullUtils;
import cn.zwz.doctor.entity.Prescribing;
import cn.zwz.doctor.service.IDrugService;
import cn.zwz.doctor.service.IPrescribingService;
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
@Api(tags = "开处方管理接口")
@RequestMapping("/zwz/prescribing")
@Transactional
public class PrescribingController {

    @Autowired
    private IPrescribingService iPrescribingService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条开处方")
    public Result<Prescribing> get(@RequestParam String id){
        return new ResultUtil<Prescribing>().setData(iPrescribingService.getById(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部开处方个数")
    public Result<Long> getCount(){
        return new ResultUtil<Long>().setData(iPrescribingService.count());
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部开处方")
    public Result<List<Prescribing>> getAll(){
        return new ResultUtil<List<Prescribing>>().setData(iPrescribingService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询开处方")
    public Result<IPage<Prescribing>> getByPage(@ModelAttribute Prescribing prescribing ,@ModelAttribute PageVo page){
        QueryWrapper<Prescribing> qw = new QueryWrapper<>();
        if(!ZwzNullUtils.isNull(prescribing.getTitle())) {
            qw.like("title",prescribing.getTitle());
        }
        IPage<Prescribing> data = iPrescribingService.page(PageUtil.initMpPage(page),qw);
        return new ResultUtil<IPage<Prescribing>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改开处方")
    public Result<Prescribing> saveOrUpdate(Prescribing prescribing){
        if(iPrescribingService.saveOrUpdate(prescribing)){
            return new ResultUtil<Prescribing>().setData(prescribing);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增开处方")
    public Result<Prescribing> insert(Prescribing prescribing){
        iPrescribingService.saveOrUpdate(prescribing);
        return new ResultUtil<Prescribing>().setData(prescribing);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑开处方")
    public Result<Prescribing> update(Prescribing prescribing){
        iPrescribingService.saveOrUpdate(prescribing);
        return new ResultUtil<Prescribing>().setData(prescribing);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除开处方")
    public Result<Object> delByIds(@RequestParam String[] ids){
        for(String id : ids){
            iPrescribingService.removeById(id);
        }
        return ResultUtil.success();
    }
}
