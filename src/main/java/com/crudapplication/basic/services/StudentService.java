package com.crudapplication.basic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapplication.basic.entity.StudentEntity;
import com.crudapplication.basic.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	private List<StudentEntity> store = new ArrayList<>();
	
	public List getAllStudents() {
		List<StudentEntity> studentList = studentRepository.findAll();
		return studentList;
	}

}
