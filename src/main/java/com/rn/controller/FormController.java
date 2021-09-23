package com.rn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rn.dao.StudentRepo;
import com.rn.model.Student;

@Controller
public class FormController {

	@Autowired
	StudentRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.html";
	}

	@PostMapping(path = "/addStudent", consumes = { "application/json", "multipart/form-data",
			"application/x-www-form-urlencoded" })
	@ResponseBody
	public String addStudent(Student student) {
		repo.save(student);
		return "Student has been added successfully!!!!!!";
	}

	@GetMapping(path = "/students", produces = { "application/json" })
	@ResponseBody
	public List<Student> getAllStudent() {
		// System.out.println("Get all Students");
		return repo.findAll();
	}

	@DeleteMapping("/student/{id}")
	@ResponseBody
	public String deleteStudent(@PathVariable("id") int id) {
		repo.deleteById(id);
		return "Student has been deleted Successfully!!";
	}

	@PutMapping("/student")
	@ResponseBody
	public String saveOrUpdateStudent(@RequestBody Student student) {
		repo.save(student);
		return "Student has been updated Successfully!!";
	}

}
