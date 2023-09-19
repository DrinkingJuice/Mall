package com.example.mallmember.feign;

import com.example.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("mall-coupon") //远程指定调用哪个服务,已经注册为bean
public interface CouponFeignService {

    @RequestMapping("/mallcoupon/coupon/member/list") //远程调用coupon服务的接口
    R membercoupons();
}
