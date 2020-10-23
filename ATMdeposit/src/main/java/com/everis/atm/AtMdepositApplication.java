package com.everis.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
@ComponentScan("com.everis.atm")
public class AtMdepositApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtMdepositApplication.class, args);
	}

}
