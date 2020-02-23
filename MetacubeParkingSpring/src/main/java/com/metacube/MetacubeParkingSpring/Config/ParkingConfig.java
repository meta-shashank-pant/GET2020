package com.metacube.MetacubeParkingSpring.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.metacube.MetacubeParkingSpring.connection.ConnectionUtility;

@Configuration
@ComponentScan(basePackages = "com.metacube.*")
public class ParkingConfig {

	@Bean
	public ConnectionUtility getUtility()
	{
		return new ConnectionUtility();
	}
	
}
