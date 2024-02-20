package com.crudapplication.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudapplication.basic.entity.*;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{
	
}
