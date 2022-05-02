package com.dtp.example;

import com.dtp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * NacosExampleApplication
 *
 * @author 方便面
 * @date 2022/5/2
 */
@EnableDynamicTp
@SpringBootApplication
public class NacosExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosExampleApplication.class, args);
    }
}
