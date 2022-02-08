package com.build4c.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.build4c.dto.Customer;
import com.build4c.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/get-rest")
	public List<Customer> getCustomers_rest(){
		return service.getCustomers_rest();
	}

	@GetMapping("/get-flux")
	public Flux<Customer> getAllCustomers_flux(){
		return service.getAllCustomers();
	}
	
	@GetMapping(value = "/get-stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getAllCustomers_stream(){
		return service.getAllCustomers();
	}

}
