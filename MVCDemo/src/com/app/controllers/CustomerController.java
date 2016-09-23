package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojos.CustomerPOJO;
import com.app.service.CustomerService;

@Controller

@RequestMapping("/cust")

public class CustomerController {
	@Autowired
	private CustomerService service;

	@RequestMapping(value = "/list")
	public String listCustomers(Model map) {
		System.out.println("list custs");
		map.addAttribute("cust_list", service.getAllCustomers());
		return "list";
	}

	@RequestMapping(value = "/validate")
	public String showLoginForm(Model map) {
		System.out.println("in show login form");
		map.addAttribute(new CustomerPOJO());
		return "login";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	
	public String processLoginForm(CustomerPOJO cust123,Model map)
	{
		System.out.println("in process login form");
		System.out.println("cust details " + cust123);
		//invoke service layer method
		CustomerPOJO validCust = service.validateCustomer(cust123.getEmail(),
				cust123.getPassword());
		if (validCust == null) {
			map.addAttribute("mesg","Login Invalid , Pls retry");
			return "login";
		}
		map.addAttribute("valid_cust",validCust);
		return "valid";
	}
}
