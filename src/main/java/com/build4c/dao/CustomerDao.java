package com.build4c.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.build4c.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {
	
	private static void sleepExecution (int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<Customer> getCustomers_rest() {
		return IntStream
				.range(1, 10)
				.peek(CustomerDao::sleepExecution)
				.peek(i -> System.out.println("Processing Count:" + i))
				.mapToObj(i -> new Customer(i, "customer_" + i))
				.collect(Collectors.toList());
	}
	
	public Flux<Customer> getCustomers() {
		return Flux
				.range(1, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println("Processing Count:" + i))
				.map(i -> new Customer(i, "customer_" + i));
	}

}
