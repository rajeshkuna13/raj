package com.spring.practice.configuration;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/testApplication")
public class Controller {
	
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String testmethod()
	{
		return "Hello World";
	}
}
