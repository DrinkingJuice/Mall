package com.example.mallproduct.dao;

import com.example.mallproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author juice
 * @email zhouyingfan@gmail.com
 * @date 2023-09-17 14:22:27
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
