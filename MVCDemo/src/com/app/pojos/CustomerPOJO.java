package com.app.pojos;

import java.util.Date;


/**
 * The persistent class for the MY_CUSTOMERS database table.
 * 
 */

public class CustomerPOJO  {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double depositAmt;
	private String email="some email";
	private String name;
	private String password;
	private String role;

	public CustomerPOJO() {
				
	}
	
	public CustomerPOJO(double depositAmt, String email, String name,
			String password, String role) {
		super();
		this.depositAmt = depositAmt;
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public double getDepositAmt() {
		return this.depositAmt;
	}

	public void setDepositAmt(double depositAmt) {
		this.depositAmt = depositAmt;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "CustomerPOJO [id=" + id + ", depositAmt=" + depositAmt
				+ ", email=" + email + ", name=" + name + ", password="
				+ password + ", role=" + role + "]";
	}
	

}