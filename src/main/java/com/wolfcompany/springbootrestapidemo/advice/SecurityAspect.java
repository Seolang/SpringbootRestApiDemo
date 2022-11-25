package com.wolfcompany.springbootrestapidemo.advice;

import com.wolfcompany.springbootrestapidemo.annotation.TokenRequired;
import com.wolfcompany.springbootrestapidemo.service.SecurityServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

@Aspect
@Component
public class SecurityAspect {

    // @tokenRequired 가 적용된 메소드가 실행될 때 작동
    @Before("@annotation(tokenRequired)")
    public void authWithToken(TokenRequired tokenRequired) {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes)
                    RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // checks for token in request header
        String tokenInHeader = request.getHeader("token");
        if(!StringUtils.hasText(tokenInHeader)) {
            throw new IllegalArgumentException("Empty token");
        }

        Claims claims = Jwts.parser().setSigningKey(
                DatatypeConverter.parseBase64Binary(
                        SecurityServiceImpl.secretKey))
                .parseClaimsJws(tokenInHeader).getBody();

        if (claims == null || claims.getSubject() == null) {
            throw new IllegalArgumentException("Token Error : Claim is empty");
        }
        System.out.println("토큰에 포함된 subject로 자체 인증처리 필요...");
    }

}
