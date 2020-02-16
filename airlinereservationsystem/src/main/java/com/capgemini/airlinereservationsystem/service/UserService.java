package com.capgemini.airlinereservationsystem.service;

import java.util.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem.dto.FlightAvailability;
import com.capgemini.airlinereservationsystem.dto.Ticket;
import com.capgemini.airlinereservationsystem.dto.User;

public interface UserService {
	public User registerUser(User user);
	public User loginUser(Integer userId, String password);
	public Boolean updateUser(User user);
	public Boolean deleteUser(Integer userId);
	public Ticket bookTicket(Ticket ticket);
	public Boolean cancelTicket(Integer bookingId, Integer userId);
	public Ticket getTicketInfo(Integer bookingId);
	public Integer checkAvailability(Integer flightId, Date date);
	public List<FlightAvailability>checkAvailability(String source, String destination, Date date);
}
