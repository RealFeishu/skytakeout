package com.sky.service;

import com.sky.dto.DishDTO;

public interface DishService {

    /**
     * 新增菜品与口味
     * @param dishDTO
     */
    public void savaWithFlavor(DishDTO dishDTO);
}
