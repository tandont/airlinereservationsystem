package com.capgemini.airlinereservationsystem.exceptions;

public class FlightNotFoundException extends RuntimeException {

	public FlightNotFoundException(String s) {
		super(s);
	}
}
