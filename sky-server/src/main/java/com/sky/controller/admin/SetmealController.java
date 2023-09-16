package com.sky.controller.admin;

import com.sky.dto.DishPageQueryDTO;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Api(tags = "套餐相关接口")
@RequestMapping("/admin/setmeal")
public class SetmealController {

    @Autowired
    private SetmealService setmealService;
    /**
     * 新增套餐
     * @return
     */
    @ApiOperation("新增套餐")
    @PostMapping
    public Result save(@RequestBody  SetmealDTO setmealDTO){
        log.info("新增套餐:{}",setmealDTO);
        setmealService.saveWithDishes(setmealDTO);
        return Result.success();
    }

    /**
     * 套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("套餐分页查询")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO){
        log.info("套餐分页查询,{}",setmealPageQueryDTO);
        PageResult pageResult = setmealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 批量根据id删除套餐
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("批量根据id删除套餐")
    public Result delete(@RequestParam List<Long> ids){
        log.info("批量根据id删除套餐：{}",ids);
        setmealService.deleteByIds(ids);
        return Result.success();
    }
}
