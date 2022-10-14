package com.springrest.springrest;

//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springrest.springrest.controller.MyController;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class MyControllerTest
{
	@Autowired
	private MockMvc mockMvc;
	 
	@InjectMocks
	private MyController myController;
	
	@Before
	public void setUp() throws Exception
	{
		mockMvc = MockMvcBuilders.standaloneSetup(myController)
				.build();
	}
	
	@Test
	public void testHomePage() throws Exception{
		
		mockMvc.perform(get("/home"))
		.andExpect(status().isOk())
		.andExpect(content().string("This is Home Page"));
	}

}
