package com.example.sms_sender_api.service;

import org.springframework.stereotype.Service;

import com.example.sms_sender_api.config.TwilioConfiguration;
import com.example.sms_sender_api.dto.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service("twilio")
public class TwilioSmsSenderService implements ISmsSender {
	public final TwilioConfiguration twilioConfiguration;

	public TwilioSmsSenderService(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
	}

	@Override
	public void sendSms(SmsRequest smsRequest) {
		String to = "+55" + smsRequest.ddd() + smsRequest.phoneNumber();

		String from = "De: " + smsRequest.sender() + "\n ";
		if (isValidPhoneNumber(to)) {

			Message message = Message
					.creator(
							new PhoneNumber(to),
							new PhoneNumber(twilioConfiguration.getTrialNumber()),
							from + smsRequest.message())
					.create();
		} else {
			throw new IllegalArgumentException("Invalid phone number: " + to);
		}
	}

	private boolean isValidPhoneNumber(String fullPhoneNumber) {
		// TODO
		//
		return false;

	}
}
