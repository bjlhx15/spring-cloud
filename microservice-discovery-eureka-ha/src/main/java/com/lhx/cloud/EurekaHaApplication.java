package com.lhx.cloud;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaHaApplication {
	public static void main(String[] args) {
//		SpringApplication.run(EurekaApplication.class, args);
        // 读取控制台输入，决定使用哪个profiles
		System.out.println("输入配置：");
        Scanner scan = new Scanner(System.in);
        String profiles = scan.nextLine();
        new SpringApplicationBuilder(EurekaHaApplication.class).profiles(profiles).run(args);
	}
}
