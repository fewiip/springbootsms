package com.example.sms_sender_api.config;

import java.util.logging.Logger;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

/**
 * SenderInitializer
 */
@Configuration
public class SenderInitializer {
	public static Logger logger = Logger.getLogger(SenderInitializer.class.getName());

	public SenderInitializer(TwilioConfiguration senderConfiguration) {
		Twilio.init(senderConfiguration.getAccountSid(), senderConfiguration.getAuthToken());
		logger.info("Twilio initializer with account sid: " + senderConfiguration.getAccountSid());
	}
}
