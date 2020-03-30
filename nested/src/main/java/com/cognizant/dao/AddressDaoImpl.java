package com.cognizant.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(int houseNo, String city) {
		// TODO Auto-generated method stub
		
		String sql = "Insert into Addr values(?,?)";
		int r = jdbcTemplate.update(sql, houseNo,city);
		
	}
	
	public List<Address> getAll()
	{
		String sql = "Select * from Addr";
		
		List<Address> li = jdbcTemplate.query(sql, (rs,x)-> 
										new Address(rs.getInt(1),rs.getString(2))
									);
		return li;
	}

}
