package com.spring.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestA {

	@Autowired
	TestB b;

	public TestA() {
		System.out.println("TestA.TestA()");
	}

	public void m() {

		System.out.println("I am coming from TestA");

		b.m1();
		System.out.println(b.m2());
	}

	public static void main(String[] args) {

		AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
		annotationContext.register(TestB.class);
		annotationContext.refresh();	
		TestA a = annotationContext.getBean(TestA.class);
		a.m();
	}

}
