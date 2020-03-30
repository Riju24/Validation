package com.cognizant.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.model.Address;

@Repository
public interface AddressDao {

	void insert(int houseNo, String city);

	List<Address> getAll();

}
