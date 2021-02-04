package com.customerapp.service;

import java.util.List;

import com.customerapp.dao.Customer;

public interface CustomerService {
	public List<Customer> allCustomers();
	public Customer addCustomer(Customer customer);
}
