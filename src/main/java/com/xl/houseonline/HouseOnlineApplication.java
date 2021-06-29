package com.xl.houseonline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@MapperScan("com.xl.houseonline.dao")
@EntityScan("com.xl.houseonline.entity")
public class HouseOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseOnlineApplication.class, args);
    }

}
