package com.sergiubarsa.openfeigndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfeigndemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfeigndemoApplication.class, args);
	}

}
