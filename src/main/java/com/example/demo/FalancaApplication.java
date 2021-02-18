package com.example.demo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class FalancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FalancaApplication.class, args);
	}

	private static final Logger logger = LogManager.getLogger(FalancaApplication.class);
	@Autowired
	private CustomerRepository repository;

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		List allCustomers = this.repository.findAll();
		logger.info("Number of customers: " + allCustomers.size());
		Customer newCustomer = new Customer();
		newCustomer.setFirstName("John");
		newCustomer.setLastName("Doe");
		logger.info("Saving new customer...");
		this.repository.save(newCustomer);

		allCustomers = this.repository.findAll();
		logger.info("Number of customers: " + allCustomers.size());
	}

}
