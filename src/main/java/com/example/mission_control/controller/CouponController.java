package com.example.mission_control.controller;

import com.example.mission_control.repository.CacheRepository;
import com.example.mission_control.service.CouponService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    private final CouponService couponService;
    private final CacheRepository cacheRepository;

    public CouponController(CouponService couponService,
                            CacheRepository cacheRepository) {
        this.couponService = couponService;
        this.cacheRepository = cacheRepository;
    }

    @GetMapping()
    public Double applyCoupon(@RequestParam Integer couponId,
                              @RequestParam Double price) {
        String key = "applyCoupon" + couponId + ":" + price;
        Object cash = cacheRepository.getCash(key);
        if(cash == null) {
            Double value = couponService.applyCoupon(couponId, price);
            cacheRepository.addNewCash(key, value);
            return value;
        }
        return (double)cash;
    }
}
