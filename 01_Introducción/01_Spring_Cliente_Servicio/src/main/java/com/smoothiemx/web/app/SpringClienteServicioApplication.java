package com.smoothiemx.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringClienteServicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClienteServicioApplication.class, args);
    }
}