package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品的id来查询套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdByDishIds(List<Long> dishIds);

    /**
     * 根据套餐添加套餐中的菜品关联
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);


    /**
     * 根据ids集合中的setmeal id删除对应的关联
     * @param id
     */
    void deleteByIds(List<Long> id);

    /**
     * 根据套餐id删除菜品
     * @param setmealId
     */
    @Delete("delete from setmeal_dish where setmeal_id=#{setmealId}")
    void deleteById(Long setmealId);

    /**
     * 根据套餐id获取菜品
     * @param setmealId
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id=#{dishId}")
    List<SetmealDish> getBySetmealId(Long setmealId);
}
