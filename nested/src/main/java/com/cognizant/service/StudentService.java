package com.cognizant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.model.Student;

@Service
public interface StudentService {

	public int create(Student student);
	
	public int update(Student student);
	
	public int delete(Student student);
	
	public List<Student> findAll();

	public Student getById(int id);
	
}
