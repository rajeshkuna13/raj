package com.spring.practice.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ApplicationExecution implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext webApplication = new AnnotationConfigWebApplicationContext();
		webApplication.register(LocalEntityManagerFactorBeanConfiguration.class);
		webApplication.refresh();
		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(webApplication);
		servletContext.addListener(contextLoaderListener);
		webApplication.setServletContext(servletContext);
		ServletRegistration.Dynamic dynamicServlet = servletContext.addServlet("SpringRest", new ServletContainer());
		dynamicServlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES, "com.spring.practice.configuration");
		dynamicServlet.setLoadOnStartup(1);
		dynamicServlet.addMapping("/rest/*");

	}
}
