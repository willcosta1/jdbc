package com.will.data;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private Connection connection;

	public Connection getConnection() {
		try {
			if (connection == null) {
				Properties properties = new Properties();
				properties = getProperties();
				connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
						properties.getProperty("password"));
				return connection;
			} else {
				return connection;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Properties getProperties() {
		FileReader fileReader = null;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader("./config/db.properties");
			properties.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
