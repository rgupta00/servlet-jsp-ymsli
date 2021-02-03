package com.iris.bookapp.model.persistance;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionFactory {
	static Connection connection = null;

	public static Connection getConnection() {
		InputStream is = DbConnectionFactory.class.getClassLoader()
				.getResourceAsStream("db.properties");

		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {

			e.printStackTrace();
		}

		/*try {
			Class.forName(properties.getProperty("driver"));
			System.out.println("driver is loaded...");
		} catch (ClassNotFoundException ex) {
			System.out.println("not loaded :<");
		}*/

		try {
			connection = DriverManager.getConnection(
					properties.getProperty("url"),
					properties.getProperty("username"),
					properties.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
