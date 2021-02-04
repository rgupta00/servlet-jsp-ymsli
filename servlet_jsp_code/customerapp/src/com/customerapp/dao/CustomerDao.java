package com.customerapp.dao;
import java.util.*;
public interface CustomerDao {
	public List<Customer> allCustomers();
	public Customer addCustomer(Customer customer);
}
