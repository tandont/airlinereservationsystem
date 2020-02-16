package com.capgemini.airlinereservationsystem.service.impl;

import java.util.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem.dao.FlightBookingDAO;
import com.capgemini.airlinereservationsystem.dao.UserDAO;
import com.capgemini.airlinereservationsystem.dao.impl.FlightBookingDAOImpl;
import com.capgemini.airlinereservationsystem.dao.impl.UserDAOImpl;
import com.capgemini.airlinereservationsystem.dto.FlightAvailability;
import com.capgemini.airlinereservationsystem.dto.Ticket;
import com.capgemini.airlinereservationsystem.dto.User;
import com.capgemini.airlinereservationsystem.service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO dao = new UserDAOImpl();
	FlightBookingDAO fdao = new FlightBookingDAOImpl();
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return dao.registerUser(user);
	}
	@Override
	public User loginUser(Integer userId, String password) {
		// TODO Auto-generated method stub
		return dao.loginUser(userId, password);
	}
	@Override
	public Boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}
	@Override
	public Boolean deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return dao.deleteUser(userId);
	}
	@Override
	public Ticket bookTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return dao.bookTicket(ticket);
	}
	@Override
	public Boolean cancelTicket(Integer bookingId, Integer userId) {
		// TODO Auto-generated method stub
		return dao.cancelTicket(bookingId, userId);
	}
	@Override
	public Ticket getTicketInfo(Integer bookingId) {
		// TODO Auto-generated method stub
		return dao.getTicketInfo(bookingId);
	}
	@Override
	public Integer checkAvailability(Integer flightId, Date date) {
		// TODO Auto-generated method stub
		return fdao.checkAvailability(flightId, date);
	}
	@Override
	public List<FlightAvailability> checkAvailability(String source, String destination, Date date) {
		// TODO Auto-generated method stub
		return fdao.checkAvailability(source, destination, date);
	}
	
}
