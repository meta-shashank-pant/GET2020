package com.metacube.MetacubeParkingSpring.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.metacube.MetacubeParkingSpring.DAO.EmployeeDao;
import com.metacube.MetacubeParkingSpring.DAOImpl.EmployeeDAOImpl;
import com.metacube.MetacubeParkingSpring.connection.ConnectionUtility;


@Configuration
@ComponentScan(basePackages = "com.metacube.*")
@PropertySource("classpath:database.properties")
public class ParkingConfig {

	@Bean
	public ConnectionUtility getUtility()
	{
		return new ConnectionUtility();
	}
	
	@Autowired
	Environment environment;
	
	private final String url = "url";
	private final String dbuser = "dbuser";
	private final String driver = "driver";
	private final String dbpassword = "dbpassword";
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(url));
		driverManagerDataSource.setUsername(environment.getProperty(dbuser));
		driverManagerDataSource.setPassword(environment.getProperty(dbpassword));
		driverManagerDataSource.setDriverClassName(environment.getProperty(driver));
		return driverManagerDataSource;
	}
	
//	@Bean
//	EmployeeDao getEmployeeDAO() {
//		return new EmployeeDAOImpl(dataSource());
//	}
//	
	
}
