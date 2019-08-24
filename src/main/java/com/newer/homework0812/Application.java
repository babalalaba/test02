package com.newer.homework0812;


import com.newer.homework0812.mapper.adminMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.newer.homework0812.mapper")
public class Application {
@Autowired
private adminMapper am;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
