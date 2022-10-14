package com.springrest.springrest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springrest.springrest.services.CourseServices;

@SpringBootTest
public class SmokeTest 
{
	@Autowired
    private CourseServices courseServices;
	
	@Test
	void contextLoads()
	{
		assertThat(courseServices).isNotNull();	}
	
}
