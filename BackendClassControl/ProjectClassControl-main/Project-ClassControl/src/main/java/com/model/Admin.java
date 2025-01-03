package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admin_Id;

	private String admin_FullName;
	private String admin_MobileNo;
	private String admin_Username;
	private String admin_Password;

	public Admin() {
		super();
		
	}

	public Admin(int admin_Id, String admin_FullName, String admin_MobileNo,String admin_Username, String admin_Password) {
		super();
		this.admin_Id = admin_Id;
		this.admin_FullName = admin_FullName;
		this.admin_MobileNo = admin_MobileNo;
		this.admin_Username = admin_Username;
		this.admin_Password = admin_Password;
	}

	public int getAdmin_Id() {
		return admin_Id;
	}

	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}
		

	public String getAdmin_FullName() {
		return admin_FullName;
	}

	public void setAdmin_FullName(String admin_FullName) {
		this.admin_FullName = admin_FullName;
	}

	public String getAdmin_MobileNo() {
		return admin_MobileNo;
	}

	public void setAdmin_MobileNo(String admin_MobileNo) {
		this.admin_MobileNo = admin_MobileNo;
	}

	public String getAdmin_Username() {
		return admin_Username;
	}

	public void setAdmin_Username(String admin_Username) {
		this.admin_Username = admin_Username;
	}

	public String getAdmin_Password() {
		return admin_Password;
	}

	public void setAdmin_Password(String admin_Password) {
		this.admin_Password = admin_Password;
	}
	
}
