package com.example.sms_sender_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmsSenderApiApplication {

	// Find your Account SID and Auth Token at twilio.com/console
	// and set the environment variables. See http://twil.io/secure
	public static void main(String[] args) {
		// SpringBootApplication.run(SmsSenderApiApplication.class, args);
		SpringApplication.run(SmsSenderApiApplication.class, args);
	}

}
