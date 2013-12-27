package com.bedrosians.bedlogic.exeception;

public class RestError {
	private String message;

	public RestError(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
