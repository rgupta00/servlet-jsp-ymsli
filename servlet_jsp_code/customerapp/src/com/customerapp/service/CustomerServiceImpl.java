package com.customerapp.service;

import java.util.List;

import com.customerapp.dao.Customer;
import com.customerapp.dao.CustomerDao;
import com.customerapp.dao.CustomerDaoImpl;

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

}
