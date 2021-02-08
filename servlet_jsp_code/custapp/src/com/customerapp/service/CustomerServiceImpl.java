package com.customerapp.service;

import java.util.List;

import com.customerapp.customer.Customer;
import com.customerapp.customer.CustomerDao;
import com.customerapp.customer.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao;
	
	
	public CustomerServiceImpl() {
		this.customerDao=new CustomerDaoImpl();
	}

	@Override
	public List<Customer> allCustomers() {
		
		//BL latter on when we will use spring
		return customerDao.allCustomers();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}

	@Override
	public void updateCustomer(int id, Customer customer) {
		customerDao.updateCustomer(id, customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

}
