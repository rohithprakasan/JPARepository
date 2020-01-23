package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.RollNo;
import com.example.demo.Entity.Students;
import com.example.demo.Repo.RollNoRepo;
import com.example.demo.Repo.StudentRepo;

@RestController
public class StudentController {

	
	@Autowired StudentRepo studentrepo;
	@Autowired RollNoRepo rollRepo;
	
	
	@RequestMapping(path = "/getByName",method = RequestMethod.GET)
	public List<Students> getbyName(@RequestParam(name = "name") String name){
		System.out.println("name "+name);
		return studentrepo.findByNameContaining(name);
		
	}
	
	@RequestMapping(path = "/getByExactName",method = RequestMethod.GET)
	public List<Students> getByExactName(@RequestParam(name = "name") String name){
		System.out.println("name "+name);
		return studentrepo.findByName(name);
		
	}
	
	@RequestMapping(path = "/getAll",method = RequestMethod.GET)
	public List<Students> getAll(){
		
		return studentrepo.findAll();
		
	}
	
	@RequestMapping(path = "/getByRollNo",method = RequestMethod.GET)
	public Students getByRollNo(@RequestParam(name = "rollno") String rollNo){
		System.out.println("rollNo :"+rollNo);
		RollNo rollObj=rollRepo.findByRollNo(rollNo);
		return studentrepo.findByRollNo(rollObj);
	}
	
	@RequestMapping(path = "/deleteByRollNo")
	public void deleteByRollNo(@RequestParam(name = "rollno") String rollNo){
		
		RollNo rollObj=rollRepo.findByRollNo(rollNo);
		Students studObj=studentrepo.findByRollNo(rollObj);
		studentrepo.delete(studObj);
		rollRepo.delete(rollObj);
		
	}
	
}
