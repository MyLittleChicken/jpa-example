package com.example.jpaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * JPA 의존성 분리 예제 애플리케이션
 * 
 * 이 애플리케이션은 데이터 접근 계층을 인터페이스로 추상화하여
 * JPA나 다른 데이터 접근 기술 변경에 따른 영향을 최소화하는 방법을 보여줍니다.
 */
@SpringBootApplication
public class JpaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaExampleApplication.class, args);
    }
}
