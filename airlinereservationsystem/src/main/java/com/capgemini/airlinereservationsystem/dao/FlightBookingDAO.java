package com.capgemini.airlinereservationsystem.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem.dto.Flight;
import com.capgemini.airlinereservationsystem.dto.FlightAvailability;

public interface FlightBookingDAO {
	public Flight searchFlight(Integer flightId);
	public Integer checkAvailability(Integer flightId, Date date);
	public List<FlightAvailability>checkAvailability(String source, String destination, Date date);
}
