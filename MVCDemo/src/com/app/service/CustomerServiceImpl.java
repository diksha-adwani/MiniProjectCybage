package com.app.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.pojos.CustomerPOJO;

@Service
public class CustomerServiceImpl implements CustomerService {
	private HashMap<String, CustomerPOJO> customers;

	public CustomerServiceImpl() {
		customers = new HashMap<>();
		customers.put("abc@gmail", new CustomerPOJO(123, "a@gmail", "a", "a#123",
				"admin"));
		customers.put("pqr@gmail", new CustomerPOJO(500, "b@gmail", "b", "b#123",
			 "cust"));
		System.out.println("service constr");
	}

	// list all customers
	@Override
	public List<CustomerPOJO> getAllCustomers() {
		return new ArrayList<>(customers.values());
	}

	@Override
	public CustomerPOJO validateCustomer(String em, String pass) {
		CustomerPOJO cust = customers.get(em);
		if (cust != null && cust.getPassword().equals(pass))
			return cust;
		return null;
	}

}
