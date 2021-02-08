package com.customerapp.service;

import java.util.List;

import com.customerapp.customer.Customer;

public interface CustomerService {
	public List<Customer> allCustomers();
	public Customer addCustomer(Customer customer);
	public void deleteCustomer(int id);
	public void updateCustomer(int id, Customer customer);
	public Customer getCustomerById(int id);

}
