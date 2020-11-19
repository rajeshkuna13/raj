package com.spring.practice.configuration;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	public BasicDataSource dataSourceConfiguration()
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(dataBaseProperties().getProperty("database.url"));
		dataSource.setUsername(dataBaseProperties().getProperty("database.username"));
		dataSource.setPassword(dataBaseProperties().getProperty("database.password"));
		dataSource.setDriverClassName(dataBaseProperties().getProperty("database.driver"));
		return dataSource;
	}
	
	public Properties dataBaseProperties()
	{
		Properties prop = new Properties();
		prop.setProperty("datbase.driver", environment.getProperty("db.driver"));
		prop.setProperty("database.url", environment.getProperty("db.url"));
		prop.setProperty("database.userName", environment.getProperty("db.username"));
		prop.setProperty("database.password", environment.getProperty("db.password"));
		return prop;
	}
	
	
}
