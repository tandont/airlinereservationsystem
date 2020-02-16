package com.capgemini.airlinereservationsystem.service;

import com.capgemini.airlinereservationsystem.dto.Admin;
import com.capgemini.airlinereservationsystem.dto.Personnel;


public interface AdminService {
	public Admin adminLogin(Integer adminId, String password);

	public Boolean deletePersonnel(Integer personnelId);
	
	public Boolean deleteUser(Integer userId);

	public Personnel registerPersonnel(Personnel personnel);
}
