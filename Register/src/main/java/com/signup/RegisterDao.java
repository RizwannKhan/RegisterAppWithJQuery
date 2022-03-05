package com.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

	private static final String dbUrl = "jdbc:mysql://localhost:3306/user_management";
	private static final String dbUser = "root";
	private static final String dbPass = "1234";
	private static final String dbDriver = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static String createMember(MemberRegister member) {
		String result = "Done";
		Connection con = getConnection();
		String query = "insert into signup(firstName, lastName, password, email, image) values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, member.getFirstname());
			stmt.setString(2, member.getLastname());
			stmt.setString(3, member.getPassword());
			stmt.setString(4, member.getEmail());
			stmt.setString(5, member.getImage());
			System.out.println(stmt);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Error";
		}

		return result;
	}

}
