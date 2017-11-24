package com.nagarro.adminPortal.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPortal.model.Customer;
import com.nagarro.adminPortal.model.Balance;
import com.nagarro.adminPortal.repository.CustomerRepository;

/**
 * @author archanabanga
 * This service deals with customer related database operation using customer repository like
 * CRUD and searches based on condition
 */
@Service
public class CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	/**
	 * Saves customer record in database
	 * @param Customer
	 * @return customer record
	 */
	public Customer register(Customer customer){
		return customerRepository.save(customer);
	}
	
	/**
	 * Blocks Customer Bet Amount 
	 * @param Balance
	 * @return updated customer record
	 */
	public Customer updateBlockedAmount(Balance blockBalance){
		Customer c = customerRepository.findOne(blockBalance.getUniqueId());
		c.setBlockedAmount(blockBalance.getAmount());
		c.setBalance(c.getBalance() - blockBalance.getAmount());
		return customerRepository.save(c);
	}
	
	/**
	 * Updates Customer winning amount in database
	 * @param winningBalance
	 * @return updated customer record
	 */
	public Customer updateBalance(Balance winningBalance){
		Customer c = customerRepository.findOne(winningBalance.getUniqueId());
		c.setBalance(c.getBalance() + winningBalance.getAmount());
		c.setBlockedAmount(0);
		return customerRepository.save(c);
	}
	
	/**
	 * Recharge Customer with amount requested
	 * @param Customer id
	 * @param amount
	 * @return
	 */
	public Customer recharge(String id,int amount){
		Customer customer = customerRepository.findOne(id);
		customer.setBalance(customer.getBalance()+amount);
		return customerRepository.save(customer);
	}
	
	/**
	 * Request Customer Record from database
	 * @param id
	 * @return customer record
	 */
	public Customer getCustomer(String id){
		return customerRepository.findOne(id);
	}
	
	/**
	 * Get All Customer Record from Database 
	 * @return list of customer record
	 */
	public List<Customer> getRecords() {
		List<Customer> list = (List<Customer>) customerRepository.findAll();
		return list;
	}
	
	/**
	 * Searched customer based on customer name
	 * @param name
	 * @return customer record satisfing condition
	 */
	public List<Customer> getRecordsByName(String name){
		List<Customer> list = (List<Customer>) customerRepository.findByNameContaining(name);
		return list;
	}
	
	/**
	 * Searched customer based on customer email
	 * @param email
	 * @return customer record satisfing condition
	 */
	public List<Customer> getRecordsByEmail(String email){
		List<Customer> list = (List<Customer>) customerRepository.findByEmailContaining(email);
		return list;
	}
	
	/**
	 * Searched customer based on customer contact number
	 * @param conatct number
	 * @return customer record satisfing condition
	 */
	public List<Customer> getRecordsByContact(String contact){
		List<Customer> list = (List<Customer>) customerRepository.findByContactContaining(contact);
		return list;
	}
	
	/**
	 * Searched customer based on customer name or contact number
	 * @param name
	 * @param contact number
	 * @return customer record satisfing condition
	 */
	public List<Customer> getRecordsByNameOrContact(String name,String contact){
		List<Customer> list = (List<Customer>) customerRepository.findCustomerByNameOrContactContaining(name, contact);
		return list;
	}
	
	/**
	 * Searched customer based on customer name or email
	 * @param name
	 * @param email
	 * @return customer record satisfing condition
	 */
	public List<Customer> getRecordsByNameOrEmail(String name,String email){
		List<Customer> list = (List<Customer>) customerRepository.findCustomerByNameOrEmailContaining(name, email);
		return list;
	}
	
	/**
	 * Searched customer based on customer number or email
	 * @param contact number
	 * @param email
	 * @return customer record satisfing condition
	 */
	public List<Customer> getRecordsByContactOrEmail(String contact,String email){
		List<Customer> list = (List<Customer>) customerRepository.findCustomerByContactOrEmailContaining(contact, email);
		return list;
	}
	
}
