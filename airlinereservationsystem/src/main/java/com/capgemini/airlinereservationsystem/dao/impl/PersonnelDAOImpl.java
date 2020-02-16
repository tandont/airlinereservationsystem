package com.capgemini.airlinereservationsystem.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.capgemini.airlinereservationsystem.dao.FlightBookingDAO;
import com.capgemini.airlinereservationsystem.dao.PersonnelDAO;
import com.capgemini.airlinereservationsystem.dto.Flight;
import com.capgemini.airlinereservationsystem.dto.FlightAvailability;
import com.capgemini.airlinereservationsystem.dto.Personnel;
import com.capgemini.airlinereservationsystem.dto.Ticket;
import com.capgemini.airlinereservationsystem.util.AirlineReservationSystem;

public class PersonnelDAOImpl implements PersonnelDAO {

	FlightBookingDAO bookingDAO = new FlightBookingDAOImpl();

	public PersonnelDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Personnel loginPersonnel(Integer personnelId, String password) {
		String query = "SELECT * FROM user_details where userId=" + personnelId + " and userPassword='" + password
				+ "' and userType='personnel'";
		Personnel personnel = null;

		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(query)) {
			if (resultset.next()) {
				personnel = new Personnel();
				personnel.setPersonnelId(resultset.getInt("userId"));
				personnel.setPersonnelPassword(resultset.getString("userPassword"));
				personnel.setPersonnelName(resultset.getString("userName"));
				personnel.setPersonnelEmail(resultset.getString("userEmail"));
				personnel.setPersonnelContact(resultset.getLong("userContact"));
				return personnel;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personnel;
	}

	@Override
	public Flight addFlight(Flight flight) {
		String query = "INSERT INTO flight_details VALUES (?,?,?,?,?,?,?)";
		Flight tempflight = bookingDAO.searchFlight(flight.getFlightId());

		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(query);) {
			if (tempflight != null) {
				return null;
			} else {
				pstmt.setInt(1, flight.getFlightId());
				pstmt.setString(2, flight.getFlightName());
				pstmt.setString(3, flight.getSource());
				pstmt.setString(4, flight.getDestination());
				pstmt.setString(5, flight.getFlightType());
				pstmt.setInt(6, flight.getTotalSeats());
				pstmt.setDouble(7, flight.getPrice());

				pstmt.executeUpdate();
				return flight;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean updateFlight(Flight flight) {
		String query = "UPDATE flight_details SET flightName=?,source=?,destination=?,"
				+ "flightType=?,totalSeats=?,price=? WHERE flightId=?";
		Flight tempflight = bookingDAO.searchFlight(flight.getFlightId());

		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(query);) {
			if (tempflight != null) {
				pstmt.setString(1, flight.getFlightName());
				pstmt.setString(2, flight.getSource());
				pstmt.setString(3, flight.getDestination());
				pstmt.setString(4, flight.getFlightType());
				pstmt.setInt(5, flight.getTotalSeats());
				pstmt.setDouble(6, flight.getPrice());
				pstmt.setInt(7, flight.getFlightId());

				pstmt.executeUpdate();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteFlight(Integer flightId) {
		String query = "DELETE FROM flight_details WHERE flightId=?";
		Flight flight = bookingDAO.searchFlight(flightId);

		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(query);) {
			if (flight != null) {
				pstmt.setInt(1, flightId);
				pstmt.executeUpdate();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Integer> getAllTicket(Integer userId) {
		String query = "SELECT  * FROM booking_info where userId=" + userId;
		List<Integer> ticketAl = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(query)) {
			while (resultset.next()) {
				ticketAl.add(resultset.getInt("bookingId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticketAl;
	}

	@Override
	public List<Ticket> getTicketByFlight(Integer flightId, Date tempDate) {
		java.sql.Date date = new java.sql.Date(tempDate.getTime());

		String query = "SELECT  * FROM booking_info where flightId=" + flightId + " and journDate='" + date + "'";
		List<Ticket> ticketAl = new ArrayList<>();

		Ticket ticket = null;
		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query)) {
			while (rs.next()) {
				ticket = new Ticket();
				ticket.setBookingId(rs.getInt("bookingId"));
				ticket.setUserId(rs.getInt("userId"));
				ticket.setFlightId(rs.getInt("flightId"));
				ticket.setJourneyDate(rs.getDate("journDate"));
				ticket.setNumOfSeats(rs.getInt("noSeats"));
				ticket.setBookingDateTime(rs.getTimestamp("bookingDT"));
				ticketAl.add(ticket);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticketAl;
	}

	@Override
	public Boolean setFlightAvailability(FlightAvailability availability) {
		java.sql.Date date = new java.sql.Date(availability.getAvailDate().getTime());

		String query = "INSERT INTO availability (availDate,availSeats,flightId) VALUES (?,?,?)";

		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(query)) {
			pstmt.setDate(1, date);
			pstmt.setInt(2, availability.getAvailSeat());
			pstmt.setInt(3, availability.getFlightId());
			int res = pstmt.executeUpdate();
			if (res > -1)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
