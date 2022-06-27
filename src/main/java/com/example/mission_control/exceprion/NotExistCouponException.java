package com.example.mission_control.exceprion;

public class NotExistCouponException extends RuntimeException{
    public NotExistCouponException(String message) {
        super(message);
    }

    public NotExistCouponException(String message, Throwable cause) {
        super(message, cause);
    }
}
