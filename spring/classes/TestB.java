package com.spring.classes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.classes")
public class TestB {
	public TestB() {
		System.out.println("TestB.TestB()");
	}

	@Bean(name = "testBean")
	public int m1() {
		System.out.println("I am coming from testb class");
		return 0;
	}

	@Bean
	public String m2() {
		return "I am coming from testB class of m2 method";
	}
}
