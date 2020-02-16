package com.capgemini.airlinereservationsystem.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.capgemini.airlinereservationsystem.dao.AdminDAO;
import com.capgemini.airlinereservationsystem.dto.Admin;
import com.capgemini.airlinereservationsystem.dto.Personnel;
import com.capgemini.airlinereservationsystem.util.AirlineReservationSystem;

public class AdminDAOImpl implements AdminDAO {
	public AdminDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Admin adminLogin(Integer adminId, String password) {
		String query = "SELECT * FROM user_details where userId=" + adminId + " and userPassword='" + password
				+ "' and userType = 'admin'  ";
		Admin admin = null;

		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(query)) {
			if (resultset.next()) {
				admin = new Admin();
				admin.setAdminId(resultset.getInt("userId"));
				admin.setAdminPassword(resultset.getString("userPassword"));
				admin.setAdminName(resultset.getString("userName"));
				admin.setAdminEmail(resultset.getString("userEmail"));
				admin.setAdminContact(resultset.getLong("userContact"));
				return admin;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public Personnel registerPersonnel(Personnel personnel) {
		String query = "INSERT INTO user_details VALUES (?,?,?,?,?,?)";
		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(query);) {
			pstmt.setInt(1, personnel.getPersonnelId());
			pstmt.setString(2, personnel.getPersonnelName());
			pstmt.setString(3, personnel.getPersonnelEmail());
			pstmt.setString(4, personnel.getPersonnelPassword());
			pstmt.setLong(5, personnel.getPersonnelContact());
			pstmt.setString(6, "personnel");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personnel;
	}

	@Override
	public Boolean deletePersonnel(Integer personnelId) {
		String query = "DELETE FROM user_details WHERE userId=? and userType ='personnel'";
		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(query);) {
			pstmt.setInt(1, personnelId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		String query = "DELETE FROM user_details WHERE userId=? and userType = 'user'";
		try (Connection connection = DriverManager.getConnection(AirlineReservationSystem.DB_URL,
				AirlineReservationSystem.DB_USER, AirlineReservationSystem.DB_PASSWORD);
				PreparedStatement pstmt = connection.prepareStatement(query);) {
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
