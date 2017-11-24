package com.nagarro.adminPortal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPortal.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>{

	List<Customer> findByEmailContaining(String email);
	List<Customer> findByNameContaining(String name);
	List<Customer> findByContactContaining(String contact);
	List<Customer> findCustomerByNameOrContactContaining(String name, String contact);
	List<Customer> findCustomerByNameOrEmailContaining(String name, String email);
	List<Customer> findCustomerByContactOrEmailContaining(String contact, String email);

}
