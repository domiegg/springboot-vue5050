package cn.zwz.doctor.controller;

import cn.zwz.basics.utils.PageUtil;
import cn.zwz.basics.utils.ResultUtil;
import cn.zwz.basics.baseVo.PageVo;
import cn.zwz.basics.baseVo.Result;
import cn.zwz.data.utils.ZwzNullUtils;
import cn.zwz.doctor.entity.Drug;
import cn.zwz.doctor.service.IDrugService;
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
@Api(tags = "药品管理接口")
@RequestMapping("/zwz/drug")
@Transactional
public class DrugController {

    @Autowired
    private IDrugService iDrugService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条药品")
    public Result<Drug> get(@RequestParam String id){
        return new ResultUtil<Drug>().setData(iDrugService.getById(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部药品个数")
    public Result<Long> getCount(){
        return new ResultUtil<Long>().setData(iDrugService.count());
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部药品")
    public Result<List<Drug>> getAll(){
        return new ResultUtil<List<Drug>>().setData(iDrugService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询药品")
    public Result<IPage<Drug>> getByPage(@ModelAttribute Drug drug ,@ModelAttribute PageVo page){
        QueryWrapper<Drug> qw = new QueryWrapper<>();
        if(!ZwzNullUtils.isNull(drug.getTitle())) {
            qw.like("title",drug.getTitle());
        }
        IPage<Drug> data = iDrugService.page(PageUtil.initMpPage(page),qw);
        return new ResultUtil<IPage<Drug>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改药品")
    public Result<Drug> saveOrUpdate(Drug drug){
        if(iDrugService.saveOrUpdate(drug)){
            return new ResultUtil<Drug>().setData(drug);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增药品")
    public Result<Drug> insert(Drug drug){
        iDrugService.saveOrUpdate(drug);
        return new ResultUtil<Drug>().setData(drug);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑药品")
    public Result<Drug> update(Drug drug){
        iDrugService.saveOrUpdate(drug);
        return new ResultUtil<Drug>().setData(drug);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除药品")
    public Result<Object> delByIds(@RequestParam String[] ids){
        for(String id : ids){
            iDrugService.removeById(id);
        }
        return ResultUtil.success();
    }
}
