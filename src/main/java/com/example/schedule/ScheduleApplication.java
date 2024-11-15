package com.example.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/* @EnableJpaAuditing 으로 application 실행시
   데이터 생성되거나 수정시 해당 필드에 자동으로 날짜나 사용자 정보 생성
 */
@EnableJpaAuditing
@SpringBootApplication
public class ScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }

}
