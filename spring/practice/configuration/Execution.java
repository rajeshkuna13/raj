package com.spring.practice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.spring.practice.configuration.LocalEntityManagerFactorBeanConfiguration;


@Component
public class Execution {
	/*
	@Autowired
	DataSourceConfig dbConfig;*/
	
	@Autowired
	LocalEntityManagerFactorBeanConfiguration localEntityConfiguration;

/*	public void m()
	{
			new WebApplicationInitializer() //Anonymous Inner Interface
			{

				@Override
				public void onStartup(ServletContext servletContext) throws ServletException {
			
				AnnotationConfigWebApplicationContext configContext = new AnnotationConfigWebApplicationContext();
				configContext.register(LocalEntityManagerFactorBeanConfiguration.class);
				servletContext.addListener(new ContextLoaderListener(configContext));
				configContext.register(ServletContainer.class);
				}
				
			};
	}*/
	/*public void execute() {
		try {
			BasicDataSource dataSource = dbConfig.dataSourceConfiguration();
			Connection con = dataSource.getConnection();
			if (null != con) {
				System.out.println("Connection success");
			}
			else
			{
				System.out.println("Connection fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationContext= new AnnotationConfigApplicationContext();
		annotationContext.register(LocalEntityManagerFactorBeanConfiguration.class);
		annotationContext.refresh();
		Execution execution = annotationContext.getBean(Execution.class);
		System.out.println(execution);
	}
}
