package com.cred.io.controller;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.cred.io.model.Card;
import com.cred.io.model.Customer;
import com.cred.io.repository.CustomerRepository;



@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	
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
		String card = Long.toString(customer.getCard());
		
		String url = "https://lookup.binlist.net/" + card;
		
		try {
		restTemplate.getForObject(url, Card.class);
	    repository.save(customer);
		} catch (HttpStatusCodeException ex)
		{
			System.out.print("Error: 404, Invalid card number");
		}
	
    }
		
	
	@RequestMapping(method = RequestMethod.PUT, value="/customers/{customerID}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable String customerID){
		long id = Long.parseLong(customerID);
		Customer currentCustomer = repository.findById(id);
		
		currentCustomer.setCard(customer.getCard());
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
