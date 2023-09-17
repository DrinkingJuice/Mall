package com.example.mallware.dao;

import com.example.mallware.entity.WareInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author juice
 * @email zhouyingfan@gmail.com
 * @date 2023-09-17 17:52:49
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
