package com.app.service;

import java.util.List;

import com.app.pojos.CustomerPOJO;

public interface CustomerService {
	 List<CustomerPOJO> getAllCustomers();
	 
	 CustomerPOJO validateCustomer(String em,String pass);
}
