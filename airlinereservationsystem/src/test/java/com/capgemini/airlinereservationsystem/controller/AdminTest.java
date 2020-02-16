package com.capgemini.airlinereservationsystem.controller;

import org.junit.jupiter.api.Test;

import com.capgemini.airlinereservationsystem.dao.impl.AdminDAOImpl;

public class AdminTest {
	AdminDAOImpl a1 = new AdminDAOImpl();
	@Test
	void deleteUserTest() {
		a1.deleteUser(1001);
	}
	@Test
	void deletePersonnelTest() {
		a1.deletePersonnel(1000);
	}
	@Test
	void adminLogin() {
		a1.adminLogin(1000, "qwerty@12");
	}
}