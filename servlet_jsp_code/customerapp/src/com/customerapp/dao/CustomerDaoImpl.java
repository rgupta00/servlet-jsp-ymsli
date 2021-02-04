package com.customerapp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{

	private Connection connection;
	
	
	public CustomerDaoImpl() {
		this.connection=ConnectionFactory.getConnection();
	}

	@Override
	public List<Customer> allCustomers() {
		
		return null;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		//
		try {
			PreparedStatement pstmt=connection.
					prepareStatement
					("insert into customer(name, address, mobile, email, dob) values(?,?,?,?,?)", 
							Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getAddress());
			pstmt.setString(3, customer.getMobile());
			pstmt.setString(4, customer.getEmail());
			pstmt.setDate(5, new java.sql.Date(customer.getDob().getTime()));
			
			pstmt.executeUpdate();
			
			ResultSet rs=pstmt.getGeneratedKeys();
			if(rs.next()) {
				customer.setId(rs.getInt(1));
			}
			
		}catch(SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}
		
		return customer;
	}

}
