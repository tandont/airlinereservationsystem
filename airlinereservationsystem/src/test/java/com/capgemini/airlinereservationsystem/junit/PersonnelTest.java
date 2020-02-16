package com.capgemini.airlinereservationsystem.junit;

import org.junit.jupiter.api.Test;

import com.capgemini.airlinereservationsystem.dao.impl.PersonnelDAOImpl;

public class PersonnelTest {
	PersonnelDAOImpl p1 = new PersonnelDAOImpl();
	
	@Test
	void deleteFlightTest() {
		p1.deleteFlight(1000);
	}
	
	@Test
	void updateFlightTest() {
		p1.getAllTicket(1000);
	}
}
