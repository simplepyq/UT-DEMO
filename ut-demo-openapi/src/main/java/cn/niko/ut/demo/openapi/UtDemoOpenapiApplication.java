package cn.niko.ut.demo.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.niko.ut.demo")
public class UtDemoOpenapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtDemoOpenapiApplication.class, args);
    }

}
