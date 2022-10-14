package com.springrest.springrest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

//Web layer test
@WebMvcTest
public class WebLayerTest 
{


	@Autowired
	private MockMvc mockMvc;
	
	public void DefaultMessage() throws Exception
	{
		this.mockMvc.perform(get("/home")).andDo(print()).andExpect(status().isOk()) 
		.andExpect(content().string(containsString("This is Home Page")));
	}
}
