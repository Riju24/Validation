package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Address;
import com.cognizant.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(Integer id, String name, String course, int houseNo) {
		// TODO Auto-generated method stub
		
		String sql = "Insert into Stu values(?,?,?,?)";
		int r = jdbcTemplate.update(sql,id,name,course,houseNo);
		
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
		String sql = "Delete from Stu where id=?";
		int r = jdbcTemplate.update(sql,id);
		
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		String sql ="Select * from Stu s, Addr r where s.house_no = r.house_no";
		
		List<Student> list = jdbcTemplate.query(sql,(rs,x)-> 
									new Student(
												rs.getInt(1), 
												rs.getString(2),
												rs.getString(3),
												new Address(rs.getInt(5),rs.getString(6))
												)
												);
		
		return list;
	}

	@Override
	public void update(Integer id, String name, String course, int houseNo) {
		// TODO Auto-generated method stub
		
		String sql ="Update Stu set name=?,course=?,house_no=? where id = ? ";
		int r = jdbcTemplate.update(sql,name,course,houseNo,id);
	}

	@Override
	public Student getId(int id) {
		
		String sql = "Select * from Stu s, Addr r where s.id= ? and s.house_no = r.house_no";
		List<Student> s = jdbcTemplate.query(sql,new Object[] {id},(rs,x)->
							new Student(rs.getInt(1),rs.getString(2),rs.getString(3),new Address(rs.getInt(5),rs.getString(6)))
							);
		
		Student stu = s.get(0);
		return stu;
		
	}

}
