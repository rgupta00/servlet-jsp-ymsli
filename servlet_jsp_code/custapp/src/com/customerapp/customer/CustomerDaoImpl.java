package com.customerapp.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customerapp.dao.ConnectionFactory;
import com.customerapp.dao.CustomerNotFoundException;
import com.customerapp.dao.DataAccessException;

public class CustomerDaoImpl implements CustomerDao {

	private Connection connection;

	public CustomerDaoImpl() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Customer> allCustomers() {
		// id ,name ,address, mobile ,email , dob
		List<Customer> customers = new ArrayList<>();
		Customer customer = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
			while (rs.next()) {
				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"),
						rs.getString("mobile"), rs.getString("email"), rs.getDate("dob"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}

		return customers;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		//
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"insert into customer(name, address, mobile, email, dob) values(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getAddress());
			pstmt.setString(3, customer.getMobile());
			pstmt.setString(4, customer.getEmail());
			pstmt.setDate(5, new java.sql.Date(customer.getDob().getTime()));

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				customer.setId(rs.getInt(1));
			}

		} catch (SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}

		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		try {
			PreparedStatement pstmt = connection.prepareStatement
					("delete from customer where id=?");

			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		} catch (SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}

	}

	@Override
	public void updateCustomer(int id, Customer customer) {
		//address      | mobile     | email
		try {
			PreparedStatement pstmt = connection.prepareStatement
					("update customer set address=? ,mobile=? ,email=? where id=?");
			pstmt.setString(1, customer.getAddress());
			pstmt.setString(2, customer.getMobile());
			pstmt.setString(3, customer.getEmail());
			
			pstmt.setInt(4, id);
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer=null;
		try {
			PreparedStatement pstmt = 
					connection.prepareStatement
					("select * from customer where id=?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"),
						rs.getString("mobile"), rs.getString("email"), rs.getDate("dob"));
			}else {
				throw new CustomerNotFoundException("customer with id "+ id +" is not found");
			}

		} catch (SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}
		return customer;
	}

}
