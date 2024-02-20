package com.crudapplication.basic.entity;

import jakarta.persistence.*;

@Entity

@Table(name="students") //if it was not defined then it will autocreate as  student_entity
public class StudentEntity {
	@Id
	private int rollNo;
	private String name;
	private String Address;
	
	
	
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentEntity(int rollNo, String name, String address) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		Address = address;
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
		return "StudentEntity [rollNo=" + rollNo + ", name=" + name + ", Address=" + Address + "]";
	}
	
	
	
	

}
