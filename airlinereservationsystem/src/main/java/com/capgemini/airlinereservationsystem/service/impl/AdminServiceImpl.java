package com.capgemini.airlinereservationsystem.service.impl;

import com.capgemini.airlinereservationsystem.dao.AdminDAO;
import com.capgemini.airlinereservationsystem.dao.impl.AdminDAOImpl;
import com.capgemini.airlinereservationsystem.dto.Admin;
import com.capgemini.airlinereservationsystem.dto.Personnel;
import com.capgemini.airlinereservationsystem.service.AdminService;

public class AdminServiceImpl implements AdminService {

	AdminDAO dao = new AdminDAOImpl();

	@Override
	public Admin adminLogin(Integer adminId, String password) {
		return dao.adminLogin(adminId, password);
	}

	@Override
	public Boolean deletePersonnel(Integer personnelId) {
		return dao.deletePersonnel(personnelId);
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public Personnel registerPersonnel(Personnel personnel) {
		return dao.registerPersonnel(personnel);
	}

}
