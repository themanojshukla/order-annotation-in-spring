package com.jstobigdata.order_annotation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RunnerExampleMain {

    public static void main(String[] args) {
        SpringApplication.run(RunnerExampleMain.class, args);
    }

}

@Component
@Order(-1)
class RunFirst implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running First.");
    }

}

@Component
@Order(0)
class RunSecond implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Second.");
    }

}

@Component
@Order(Integer.MAX_VALUE)
class RunLast implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Last.");
    }

}

