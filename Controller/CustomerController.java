package com.cred.io.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cred.io.model.Customer;
import com.cred.io.repository.CustomerRepository;



@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping("/customers")
	public Iterable<Customer> getCustomers() {
		return repository.findAll();
	}
	
	@RequestMapping("/customers/{customerID}")
	public Customer getCustomerByID(@PathVariable String customerID) {
		long id = Long.parseLong(customerID);
		return repository.findById(id);
    }
	
	@RequestMapping(method = RequestMethod.POST, value="/customers")
    public void addCustomer(@RequestBody Customer customer){
        repository.save(customer);
    }
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/customers/{customerID}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable String customerID){
		long id = Long.parseLong(customerID);
		Customer currentCustomer = repository.findById(id);
		
		currentCustomer.setFirstName(customer.getFirstName());
		currentCustomer.setLastName(customer.getLastName());
		currentCustomer.setDateOfBirth(customer.getDateOfBirth());
		currentCustomer.setEmail(customer.getEmail());
		currentCustomer.setPhoneNumber(customer.getPhoneNumber());
		currentCustomer.setStatus(customer.getStatus());
		currentCustomer.setAddressLine1(customer.getAddressLine1());
		currentCustomer.setAddressLine2(customer.getAddressLine2());
		currentCustomer.setCity(customer.getCity());
        currentCustomer.setState(customer.getState());
        currentCustomer.setZipcode(customer.getZipcode());
        repository.save(currentCustomer);
        
    }
    
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/customers/{customerID}")
    public void deleteCustomer(@PathVariable String customerID) {
		long id = Long.parseLong(customerID);
        repository.deleteById(id);
    }
	

}
