package com.example.mission_control.service;

import com.example.mission_control.exceprion.NotExistCouponException;
import com.example.mission_control.repository.CouponRepository;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Double applyCoupon(Integer couponId, Double price) {
        Double coupon = null;
        try{
            coupon = couponRepository.getCouponById(couponId);
        } catch (IndexOutOfBoundsException e){
            log.info("IN applyCoupon - Coupon by this id: {} not found", couponId);
            throw new NotExistCouponException("Coupon by this id not found");
        }
            Double newPrice = price - (price * coupon / 100);
            log.info("IN applyCoupon - price has been updated");
            return newPrice;
    }

}
