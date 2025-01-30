package com.example.sms_sender_api.exception;

import java.time.LocalDateTime;

public record ExceptionDetails(
		String message,
		LocalDateTime timestamp,
		int status,
		String exception) {

}
