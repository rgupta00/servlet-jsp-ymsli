package com.iris.bookapp.model.persistance.user;

import java.sql.*;
import java.util.List;

import com.iris.bookapp.model.persistance.DataAccessExcetion;
import com.iris.bookapp.model.persistance.DbConnectionFactory;

public class UserDaoImpl implements UserDao{

	private Connection connection;
	
	public UserDaoImpl() {
		connection=DbConnectionFactory.getConnection();
	}
	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public User add(User user) {
		
		return null;
	}

	@Override
	public User delete(String username) {
		
		return null;
	}

	@Override
	public User update(User user) {
	
		return null;
	}

	@Override
	public User getUser(String username, String password) {
		User user=null;
		//get check user form the data
		try{
			PreparedStatement preparedStatement=connection.prepareStatement
					("select * from users where username=? and password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			if(rs.next()){
				user=new User(rs.getString("username"), 
						rs.getString("email"), rs.getString("password"), rs.getString("profile"));
			}else{
				throw new UserNotFoundException("user is not found");
			}
		}catch(SQLException ex){
			throw new DataAccessExcetion("some jdbc prob", ex);
		}
		return user;
	}

}













