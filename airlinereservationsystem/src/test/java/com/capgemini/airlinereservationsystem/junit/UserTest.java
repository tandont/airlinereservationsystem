package com.capgemini.airlinereservationsystem.junit;

import org.junit.jupiter.api.Test;

import com.capgemini.airlinereservationsystem.dao.impl.UserDAOImpl;
import com.capgemini.airlinereservationsystem.dto.User;

public class UserTest {
	UserDAOImpl user =new UserDAOImpl();
	@Test
	void testUserDAOImpl() {
		user.registerUser(new User(1000.90, "Tanmay", "tanmay.tandon31@gmail.com", "Spandmx@3420", 9876543210l));
	}
}
