package com.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

	private final String dbUrl = "jdbc:mysql://localhost:3306/user_management";
	private final String dbUser = "root";
	private final String dbPass = "1234";
	private final String dbDriver = "com.mysql.jdbc.Driver";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String createMember(MemberRegister member) {
		String result = "Done";
		Connection con = getConnection();
		String query = "insert into memberregister(name, password, email, gender, address) values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getEmail());
			stmt.setString(4, member.getGender());
			stmt.setString(5, member.getAddress());
			System.out.println(stmt);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Error";
		}

		return result;
	}

}
