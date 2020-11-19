package com.spring.practice.configuration;

import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value="classpath:application.properties")
@EnableTransactionManagement
@ComponentScan(basePackages="com.spring.practice.configuration")
public class LocalEntityManagerFactorBeanConfiguration {

	@Autowired
	Environment environment;
	@Autowired
	DataSourceConfig dataSourceConfig;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerConfiguration() {
		LocalContainerEntityManagerFactoryBean entityManagerBean = new LocalContainerEntityManagerFactoryBean();
		BasicDataSource dataSource = dataSourceConfig.dataSourceConfiguration();
		entityManagerBean.setDataSource(dataSource);
		entityManagerBean.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
		entityManagerBean.setPersistenceUnitName("spring-test");
		entityManagerBean.setJpaVendorAdapter(jpaVendorProperties());
		entityManagerBean.setJpaProperties(jpaProperties());
		return entityManagerBean;
	}

	@Bean
	public JpaTransactionManager transactionManagement() {
		JpaTransactionManager jpaTransaction = new JpaTransactionManager();
		LocalContainerEntityManagerFactoryBean entityManagerFactory = entityManagerConfiguration();
		jpaTransaction.setEntityManagerFactory(entityManagerFactory.getObject());
		return jpaTransaction;
	}

	public JpaVendorAdapter jpaVendorProperties() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(true);
		return jpaVendorAdapter;
	}

	public Properties jpaProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		jpaProperties.setProperty("hibernate.hbm2ddl", environment.getProperty("hibernate.hbm2ddl.auto"));
		return jpaProperties;
	}
}
