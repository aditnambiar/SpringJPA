package com.cred.io.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "customer")
public class Customer {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  private String first;
  private String last;
  private String dob;
  private String email;
  private int phone;
  private boolean status;
  private String address1;
  private String address2;
  private String city;
  private String state;
  private int zipcode;
  
  protected Customer() {}

  public Customer(String first, String last, String dob, String email, int phone, 
		  		boolean status,
		  		String address1, String address2, String city, String state, int zipcode) {
	 
      this.first = first;
      this.last = last;
      this.dob = dob;
      this.email = email;
      this.phone = phone;
      this.status = status;
      this.address1 = address1;
      this.address2 = address2;
      this.city = city;
      this.state = state;
      this.zipcode = zipcode;
  }


  public long getID() {
      return this.id;
  }
  

  public String getFirstName() {
      return first;
  }

  public void setFirstName(String firstName) {
      this.first = firstName;
  }

  public String getLastName() {
      return last;
  }

  public void setLastName(String lastName) {
      this.last = lastName;
  }

  public String getDateOfBirth() {
      return dob;
  }

  public void setDateOfBirth(String dateOfBirth) {
      this.dob = dateOfBirth;
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public int getPhoneNumber() {
      return phone;
  }

  public void setPhoneNumber(int phoneNumber) {
      this.phone = phoneNumber;
  }
  
  public boolean getStatus() {
  	return status;
  }
  
  public void setStatus(boolean status) {
  	this.status = status;
  }
  
  public String getAddressLine1() {
      return address1;
  }

  public void setAddressLine1(String addressLine1) {
      this.address1 = addressLine1;
  }

  public String getAddressLine2() {
      return address2;
  }

  public void setAddressLine2(String addressLine2) {
      this.address2 = addressLine2;
  }

  public String getCity() {
      return city;
  }

  public void setCity(String city) {
      this.city = city;
  }

  public String getState() {
      return state;
  }

  public void setState(String state) {
      this.state = state;
  }

  public int getZipcode() {
      return zipcode;
  }

  public void setZipcode(int zipcode) {
      this.zipcode = zipcode;
  }
  
  
}
