package com.example.demo.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tb_Authentication_data")
public class AuthenticationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	public AuthenticationEntity(String userName, String emailId, String password, String mobileNumber,
			String registeredDate, boolean isActive) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.registeredDate = registeredDate;
		this.isActive = isActive;
	}
	@Column(name = "userName")
	private String userName;
	@Column(name="emailId")
	private String emailId;
	@Column(name = "password")
	private String password;
	@Column(name = "mobileNumber")
	private String mobileNumber;
	@Column(name = "registeredDate")
	private String registeredDate;
	@Column(name = "isActive")
	private boolean isActive;
	@Column(name="checker")
	private String checker;
	public AuthenticationEntity(String checker) {
		super();
		this.checker = checker;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public AuthenticationEntity() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}

