package com.wolfcompany.springbootrestapidemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice   // 전역예외처리기 어노테이션
@RestController
public class GlobalExceptionHandler {

    // 수적 에러(ex/ divided by 0) 만 감지
    @ExceptionHandler(value = ArithmeticException.class)
    public Map<String, String> handleArithmeticException(ArithmeticException e) {
        Map<String, String> res = new HashMap<>();
        res.put("errorMsg", e.getMessage());
        res.put("status", "Arithmetic error");
        return res;
    }

    // Exception이 ArithmeticException보다 상위이므로,
    // handleException 메소드가 handleArithmeticException보다 아래에 있어야 한다.
    // 그렇지 않으면 Arithmetic Exception 역시 handleException이 캐치한다.


        // Exception : 모든 예외의 조상 클래스
    @ExceptionHandler(value = Exception.class)  // 모든 예외는 이 메소드로 모여 처리된다.
    public Map<String, String> handleException(Exception e) {
        Map<String, String> res = new HashMap<>();
        res.put("errorMsg", e.getMessage());
        res.put("status", "error");
        return res;
    }
}
