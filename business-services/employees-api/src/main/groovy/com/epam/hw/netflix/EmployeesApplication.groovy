package com.epam.hw.netflix


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy(proxyTargetClass = true)
class EmployeesApplication {

    static void main(String[] args) {
        SpringApplication.run(EmployeesApplication, args)
    }
}
