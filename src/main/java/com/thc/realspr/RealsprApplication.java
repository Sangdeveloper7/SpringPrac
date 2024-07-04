package com.thc.realspr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//2024-05-21 시작
//Jpa Entity 클래스
@EnableJpaAuditing
//2024-05-21 종료
@SpringBootApplication
public class RealsprApplication {
    public static void main(String[] args) {
        SpringApplication.run(RealsprApplication.class, args);
    }
}
