package com.example.mallorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallorder.entity.OrderEntity;

import java.util.Map;

/**
 * ????
 *
 * @author juice
 * @email zhouyingfan@gmail.com
 * @date 2023-09-17 17:44:12
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

