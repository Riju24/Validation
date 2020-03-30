package com.cognizant.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
public interface StudentDao {

	void insert(Integer id, String name, String course, int houseNo);

	void remove(Integer id);

	List<Student> getAll();

	void update(Integer id, String name, String course, int houseNo);

	Student getId(int id);

}
