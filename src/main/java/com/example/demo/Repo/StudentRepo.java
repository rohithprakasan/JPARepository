package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.RollNo;
import com.example.demo.Entity.Students;

@Repository
public interface StudentRepo extends JpaRepository<Students, Long>{

	
	List<Students> findByName(String name);
	List<Students> findByNameLike(String name);
	List<Students> findByNameContaining(String name);
	
	Students findByRollNo(RollNo rollNo);
}
