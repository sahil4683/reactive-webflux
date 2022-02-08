package com.build4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.build4c.dao.CustomerDao;
import com.build4c.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	
	public List<Customer> getCustomers_rest(){
		return dao.getCustomers_rest();
	}

	public Flux<Customer> getAllCustomers(){
		return dao.getCustomers();
	}

}
