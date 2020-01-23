package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.RollNo;

@Repository
public interface RollNoRepo extends JpaRepository<RollNo, Long> {

	RollNo findByRollNo(String rollno);
	
}
