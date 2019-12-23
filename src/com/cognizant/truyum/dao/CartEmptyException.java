package com.cognizant.truyum.dao;

public class CartEmptyException extends Exception {
	public CartEmptyException() {
		super("Cart Is Empty");
	}

	public CartEmptyException(String message) {
		super(message);
	}
}
