package com.capgemini.airlinereservationsystem.service.impl;

import java.util.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem.dao.PersonnelDAO;
import com.capgemini.airlinereservationsystem.dao.impl.PersonnelDAOImpl;
import com.capgemini.airlinereservationsystem.dto.Flight;
import com.capgemini.airlinereservationsystem.dto.FlightAvailability;
import com.capgemini.airlinereservationsystem.dto.Personnel;
import com.capgemini.airlinereservationsystem.dto.Ticket;
import com.capgemini.airlinereservationsystem.service.PersonnelService;

public class PersonnelServiceImpl implements PersonnelService {

	PersonnelDAO dao = new PersonnelDAOImpl();
	
	@Override
	public Personnel loginPersonnel(Integer personnelId, String password) {
		// TODO Auto-generated method stub
		return dao.loginPersonnel(personnelId, password);
	}

	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		return dao.addFlight(flight);
	}

	@Override
	public Boolean updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		return dao.updateFlight(flight);
	}

	@Override
	public Boolean deleteFlight(Integer flightId) {
		// TODO Auto-generated method stub
		return dao.deleteFlight(flightId);
	}

	@Override
	public List<Ticket> getTicketByFlight(Integer flightId, Date date) {
		// TODO Auto-generated method stub
		return dao.getTicketByFlight(flightId, date);
	}

	@Override
	public List<Integer> getAllTicket(Integer userId) {
		// TODO Auto-generated method stub
		return dao.getAllTicket(userId);
	}

	@Override
	public Boolean setFlightAvailability(FlightAvailability availability) {
		// TODO Auto-generated method stub
		return dao.setFlightAvailability(availability);
	}
	
}
