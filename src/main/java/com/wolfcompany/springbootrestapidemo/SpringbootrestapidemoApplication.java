package com.wolfcompany.springbootrestapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;

@EnableAspectJAutoProxy	// AOP 기능 활성화
@SpringBootApplication
public class SpringbootrestapidemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestapidemoApplication.class, args);
	}


}
