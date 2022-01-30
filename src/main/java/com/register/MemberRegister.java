package com.register;

public class MemberRegister {

	private int id;
	private String name;
	private String password;
	private String email;
	private String gender;
	private String address;
	
	public MemberRegister() {
	}

	public MemberRegister(String name, String password, String email, String gender, String address) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.address = address;
	}	

	public MemberRegister(int id, String name, String password, String email, String gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
