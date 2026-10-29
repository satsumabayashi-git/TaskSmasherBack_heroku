package com.example.TaskSmasher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("===== RUNNER START =====");

        try {
            System.out.println("STEP1");

            Thread.sleep(1000);

            System.out.println("STEP2");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("===== RUNNER END =====");
    }
}
