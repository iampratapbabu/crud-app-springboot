package com.crudapplication.basic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crudapplication.basic.entity.StudentEntity;
import com.crudapplication.basic.repository.StudentRepository;
import com.crudapplication.dtos.*;

@RestController
public class HomeController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@GetMapping("/")
	public CommonResponse homeFun() {
		try {
		System.out.println("home controller running");
		List<StudentEntity> studentList = studentRepository.findAll();
		System.out.println(studentList);
		CommonResponse successResponse = new CommonResponse(200,true,"return type from custom response class",studentList);
		return successResponse;
		}catch(Exception err) {
			System.out.println(err);
			CommonResponse errResponse = new CommonResponse(500,false,"Failed",err);
			return errResponse;
		}
		
	}
	
	
	@GetMapping("/res-entity")
	public  ResponseEntity<?> resEntityResponse() {
		try {
		System.out.println("home controller running");
		List<StudentEntity> studentList = studentRepository.findAll();
		System.out.println(studentList);
		var resBody = new CommonResponse(200,true,"success",studentList); //creating your custom response handler class
		return ResponseEntity.status(HttpStatus.OK).body(resBody); //and then passing it through response entity
		}catch(Exception err) {
			System.out.println(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
		}
		
	}
	
	@PostMapping("/saveStudent")
	public StudentEntity saveData(@RequestBody StudentEntity student) {
		studentRepository.save(student);
		return student;
	}
	
	@GetMapping("/singleStudent/{rollNo}")
	public ResponseEntity<?> getSingleStudent(@PathVariable int rollNo) {
		try {
		Optional<StudentEntity> student  = studentRepository.findById(rollNo);
		StudentEntity studentObj = student.get(); 
		//using builder
		System.out.println("student found"+studentObj);
		var resData = CommonResponse.builder()
				.statusCode(200)
				.success(true)
				.message("student fetched successfully")
				.resData(studentObj)
				.build();
		return ResponseEntity.status(HttpStatus.OK).body(resData);
		}catch(Exception err) {
			System.out.println(err);
			var resData = CommonResponse.builder()
					.statusCode(500)
					.success(false)
					.message(err.getMessage())
					.resData(null)
					.build();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resData);
		}
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<?> getAll(){
		try {
			List<StudentEntity> studentList = studentRepository.findAll();
			var responseObj = new CommonResponse(200,true,"student data fetched",studentList);
			return ResponseEntity.status(HttpStatus.OK).body(responseObj);
			
		}catch(Exception e) {
			System.out.println("Error Happened "+e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}

	}
	
	@DeleteMapping("/deleteStudent/{rollNo}")
	public ResponseEntity<?>  deleteStudent(@PathVariable int rollNo) {
		try {
			System.out.println("roll no got=>"+rollNo);
		String message = "";
		StudentEntity student = studentRepository.findById(rollNo).get();
		System.out.println(student);
		if(student != null) {
			studentRepository.delete(student);
			message = "student deleted successfully";
		}else {
			message ="student not found";
		}
		var responseObj = new CommonResponse(200,true,message,null);
		return ResponseEntity.status(HttpStatus.OK).body(responseObj);

		}catch(Exception e) {
			System.out.println("Error Happened "+e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); //extracting error message
			//and sending
		}
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<?> updateStudent(@RequestBody StudentEntity studentReq) {
		try {
			StudentEntity student  = studentRepository.findById(studentReq.getRollNo()).get();
			System.out.println(student);
			student.setName(studentReq.getName());
			student.setEmail(studentReq.getEmail());
			student.setAddress(studentReq.getAddress());
			studentRepository.save(student);
			var responseObj = new CommonResponse(200,true,"student data fetched",student);
			return ResponseEntity.status(HttpStatus.OK).body(responseObj);
		}catch(Exception e) {
			System.out.println("Error Happened "+e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
		
	}
	

}
