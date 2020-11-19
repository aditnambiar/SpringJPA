package com.cred.io.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cred.io.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  Customer findById(long id);
  
}
