package com.example.sms_sender_api.service;

import com.example.sms_sender_api.dto.SmsRequest;

public interface ISmsSender{
	void sendSms(SmsRequest smsRequest);
}
