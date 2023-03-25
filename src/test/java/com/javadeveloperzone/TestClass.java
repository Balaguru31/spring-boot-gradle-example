package com.javadeveloperzone;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

@MockBean
public class TestClass {

	private DemoController demoController;
	
	@Before
	public void init() {
		demoController = new DemoController();
	}
	
	@Test
	public void test() {
		System.out.println("Test Start");
		assertTrue(demoController.hello().contains("Spring boot Gradle Example"));
		System.out.println("Test End");
	}
	
}
