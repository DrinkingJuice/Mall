package com.example.mallproduct;

import com.example.mallproduct.entity.BrandEntity;
import com.example.mallproduct.service.BrandService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallProductApplicationTests {

    @Resource
    BrandService brandService;

    @Test
    void contextLoads() {
        brandService.save(new BrandEntity().setName("apple").setDescript("niubi"));
    }

    @Test
    void updateData()
    {
        BrandEntity brand = new BrandEntity().setBrandId(1L).setName("huawei").setDescript("xxx");
        brandService.updateById(brand);
    }

}
