package com.example.Order.exception;


public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(String message) {
		super(message);
	}
}
