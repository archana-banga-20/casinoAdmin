package com.nagarro.adminPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.adminPortal.model.Customer;
import com.nagarro.adminPortal.model.Balance;
import com.nagarro.adminPortal.service.CustomerService;

/**
 * 
 * @author archanabanga
 *
 *This Controller deals with the roulette application and updates customers account balance and blocks its amount 
 *as per game request 
 */
@RestController
public class Casino {

	CustomerService customerService;
	
	@Autowired
	public Casino(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	/**
	 * Searches customer based on customer id from customer service
	 * @param Customer
	 * @return customer record
	 */
	@PostMapping("/customer")
	public Customer getCustomer(@RequestBody Customer customer){
		return customerService.getCustomer(customer.getUniqueId());
	}
	
	/**
	 * Updates customer balance in customer service
	 * @param Balance
	 * @return updated customer record
	 */
	@PostMapping("/updateBalance")
	public Customer updateBalance(@RequestBody Balance winningBalance){
		return customerService.updateBalance(winningBalance);
	}
	
	/**
	 * blocks customer bet amount in customer service
	 * @param blockBalance
	 * @return updated customer record
	 */
	@PostMapping("/blockAmount")
	public Customer updateBlockedAmount(@RequestBody Balance blockBalance){
		return customerService.updateBlockedAmount(blockBalance);
	}
		
}
