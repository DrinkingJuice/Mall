package com.example.mallorder.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mallorder.entity.RefundInfoEntity;
import com.example.mallorder.service.RefundInfoService;
import com.example.common.utils.PageUtils;
import com.example.common.utils.R;



/**
 * ?˿???Ϣ
 *
 * @author juice
 * @email zhouyingfan@gmail.com
 * @date 2023-09-17 17:44:12
 */
@RestController
@RequestMapping("mallorder/refundinfo")
public class RefundInfoController {
    @Autowired
    private RefundInfoService refundInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mallorder:refundinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = refundInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mallorder:refundinfo:info")
    public R info(@PathVariable("id") Long id){
		RefundInfoEntity refundInfo = refundInfoService.getById(id);

        return R.ok().put("refundInfo", refundInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mallorder:refundinfo:save")
    public R save(@RequestBody RefundInfoEntity refundInfo){
		refundInfoService.save(refundInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mallorder:refundinfo:update")
    public R update(@RequestBody RefundInfoEntity refundInfo){
		refundInfoService.updateById(refundInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mallorder:refundinfo:delete")
    public R delete(@RequestBody Long[] ids){
		refundInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
