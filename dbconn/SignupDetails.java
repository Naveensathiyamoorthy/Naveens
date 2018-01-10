package com.dbconn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="signup")
public class SignupDetails {
	@Id
	@Column
	String emailId;
	@Column
	String firstName;
	@Column
	String lastName;
	@Column
	String userName;
	@Column
	String password;
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
