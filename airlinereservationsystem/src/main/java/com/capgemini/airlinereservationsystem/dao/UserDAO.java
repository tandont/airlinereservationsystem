package com.capgemini.airlinereservationsystem.dao;

import com.capgemini.airlinereservationsystem.dto.Ticket;
import com.capgemini.airlinereservationsystem.dto.User;

public interface UserDAO {
	public User registerUser( User user);
	public User loginUser(Integer userId, String password);
	public Boolean updateUser(User user);
	public Boolean deleteUser(Integer userId);
	public Ticket bookTicket(Ticket ticket);
	public Boolean cancelTicket(Integer bookingId, Integer userId);
	public Ticket getTicketInfo(Integer bookingId);
}
