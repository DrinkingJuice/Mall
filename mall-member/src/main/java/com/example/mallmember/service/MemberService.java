package com.example.mallmember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallmember.entity.MemberEntity;

import java.util.Map;

/**
 * ??Ա
 *
 * @author juice
 * @email zhouyingfan@gmail.com
 * @date 2023-09-17 17:32:06
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

