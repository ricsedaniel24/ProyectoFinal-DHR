package com.everis.fingerprints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FingerprintsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FingerprintsApplication.class, args);
	}

}
