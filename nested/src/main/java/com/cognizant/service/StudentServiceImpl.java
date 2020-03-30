package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.AddressDao;
import com.cognizant.dao.StudentDao;
import com.cognizant.model.Address;
import com.cognizant.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Autowired
	AddressDao addressDao;
	
	
	@Override
	public int create(Student student) {
		// TODO Auto-generated method stub
		
		addressDao.insert(student.getAddress().getHouseNo(),student.getAddress().getCity());
		studentDao.insert(student.getId(),student.getName(),student.getCourse(),student.getAddress().getHouseNo());
		
		
		return 1;
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		int flag=0;
		List<Address> ad = addressDao.getAll();
		for(Address a :ad)
		{
			if(a.getHouseNo()==student.getAddress().getHouseNo())
			{
				flag=1;
			}
		}
		
		if(flag==0)
		{
			addressDao.insert(student.getAddress().getHouseNo(), student.getAddress().getCity());
		}
		
		studentDao.update(student.getId(),student.getName(),student.getCourse(),student.getAddress().getHouseNo());
		
		return 0;
	}

	@Override
	public int delete(Student student) {
		// TODO Auto-generated method stub
		studentDao.remove(student.getId());
		
		return 0;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		
		List<Student> list = studentDao.getAll();
		
		
		return list;
	}

	@Override
	public Student getById(int id) {
		
		Student s = studentDao.getId(id);
		return s;
		
	}

}
