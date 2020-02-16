package com.capgemini.airlinereservationsystem.service.impl;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.airlinereservationsystem.dao.FlightBookingDAO;
import com.capgemini.airlinereservationsystem.dao.impl.FlightBookingDAOImpl;
import com.capgemini.airlinereservationsystem.dto.Flight;
import com.capgemini.airlinereservationsystem.dto.FlightAvailability;
import com.capgemini.airlinereservationsystem.service.FlightBookingService;

public class FlightBookingServiceImpl implements FlightBookingService {
	FlightBookingDAO dao = new FlightBookingDAOImpl();

	@Override
	public Flight searchFlight(Integer flightId) {
		// TODO Auto-generated method stub
		return dao.searchFlight(flightId);
	}

	@Override
	public Integer checkAvailability(Integer flightId, Date date) {
		// TODO Auto-generated method stub
		return dao.checkAvailability(flightId, date);
	}

	@Override
	public List<FlightAvailability> checkAvailability(String source, String destination, Date date) {
		// TODO Auto-generated method stub
		return dao.checkAvailability(source, destination, date);
	}

	@Override
	public Integer validId(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if (mat.matches()) {
			return Integer.parseInt(id);
		} else {
			return null;
		}
	}

	@Override
	public String validEmail(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(email);
		if (mat.matches()) {
			return email;
		} else {
			return null;
		}
	}

	@Override
	public Long validContact(String contact) {
		Pattern pat = Pattern.compile("\\d{10}");
		Matcher mat = pat.matcher(contact);
		if (mat.matches()) {
			return Long.parseLong(contact);
		} else {
			return null;
		}
	}

}
