package com.crudapplication.basic.entity;

import jakarta.persistence.*;

@Entity

@Table(name="students") //if it was not defined then it will autocreate as  student_entity
public class StudentEntity {
	@Id //means rollNo is primary key
	@GeneratedValue	(strategy = GenerationType.AUTO) //it is also the default value
	private int rollNo;		//GenerationType.UUID for uuid generation
	private String name;
	private String Address;
	private String email;
	private String password;
	
	
	
	public StudentEntity(int rollNo, String name, String address, String email, String password) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		Address = address;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "StudentEntity [rollNo=" + rollNo + ", name=" + name + ", Address=" + Address + ", email=" + email
				+ ", password=" + password + "]";
	}


	
	
	
	

}
