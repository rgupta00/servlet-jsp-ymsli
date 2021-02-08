package com.customerapp.customer;
import java.util.*;
public interface CustomerDao {
	public List<Customer> allCustomers();
	public Customer addCustomer(Customer customer);
	public void deleteCustomer(int id);
	public void updateCustomer(int id, Customer customer);
	public Customer getCustomerById(int id);
}
