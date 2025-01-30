package com.example.sms_sender_api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms_sender_api.dto.SmsRequest;
import com.example.sms_sender_api.service.ISmsSender;

@RestController
public class SmsSenderController {

	private final ISmsSender smsSender;

	public SmsSenderController(@Qualifier("twilio") ISmsSender smsSender) {
		this.smsSender = smsSender;
	}

	@PostMapping("/sendsms")
	public void sendSms(@RequestBody SmsRequest smsRequest) {
		smsSender.sendSms(smsRequest);
	}
}
