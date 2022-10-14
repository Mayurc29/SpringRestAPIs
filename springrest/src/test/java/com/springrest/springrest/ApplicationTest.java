package com.springrest.springrest;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.springrest.springrest.controller.MyController;

public class ApplicationTest 
{
 
	MyController mycontroller;
	/*
	@BeforeEach
	public void setup()
	{
		mycontroller = new MyController();
	}
	*/
	@Test
	public void testhome()
	{
		mycontroller = new MyController();
		assertEquals("This is Home Page",mycontroller.getCourses());
	}
}
