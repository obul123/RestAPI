package com.spring.udemy.SpringRestFromUdemy.HelloWorld;

public class HelloWorldMessage {
	
	private String Message;

	public void setMessage(String message) {
		Message = message;
	}

	public HelloWorldMessage(String message) {
		super();
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	@Override
	public String toString() {
		return "HelloWorldMessage [Message=" + Message + "]";
	}
	

}
