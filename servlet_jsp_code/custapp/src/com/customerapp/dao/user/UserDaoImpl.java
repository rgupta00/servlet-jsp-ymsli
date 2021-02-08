package com.customerapp.dao.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.customerapp.customer.Customer;
import com.customerapp.dao.ConnectionFactory;
import com.customerapp.dao.DataAccessException;

public class UserDaoImpl implements UserDao{
	
	private Connection connection;
	
	 public UserDaoImpl() {
		connection=ConnectionFactory.getConnection();
	}
	@Override
	public void addUser(User user) {
		try {
			PreparedStatement pstmt=connection.
					prepareStatement
					("insert into users(username, password, profile) values(?,?,?)");
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, "emp");
			pstmt.executeUpdate();
			
			
		}catch(SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}
	}

	@Override
	public User getUser(String username, String password) {
		User user=null;
		try {
			PreparedStatement pstmt
			=connection.prepareStatement("select * from users where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user=new User(rs.getString(1),
						rs.getString(2), 
						rs.getString(3));
			}else {
				throw new UserNotFoundException("user with name : "+ username + " is not found");
			}
		
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
		return user;
	}

}
