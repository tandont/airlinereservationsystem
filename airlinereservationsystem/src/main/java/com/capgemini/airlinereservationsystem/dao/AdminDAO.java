package com.capgemini.airlinereservationsystem.dao;

import com.capgemini.airlinereservationsystem.dto.Admin;
import com.capgemini.airlinereservationsystem.dto.Personnel;

public interface AdminDAO {
	public Admin adminLogin(Integer adminId, String password);
	public Personnel registerPersonnel(Personnel personnel);
	public Boolean deletePersonnel(Integer personnelId);
	public Boolean deleteUser(Integer userId);
}
