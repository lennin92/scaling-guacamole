package com.ingeneo.scalingguacamole;

import com.ingeneo.scalingguacamole.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ScalingGuacamoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScalingGuacamoleApplication.class, args);
    }

}
