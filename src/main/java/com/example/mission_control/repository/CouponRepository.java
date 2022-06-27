package com.example.mission_control.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class CouponRepository {
    private final List<Double> coupon;

    public CouponRepository() {
        this.coupon = new ArrayList<>();
    }

    @PostConstruct
    private void init(){
        coupon.add(0.0);
        coupon.add(10.0);
        coupon.add(50.0);
        coupon.add(60.0);

    }

   public double getCouponById(Integer couponId){
        return coupon.get(couponId);
   }
}
