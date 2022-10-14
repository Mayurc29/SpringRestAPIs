package com.springrest.springrest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest 
{
   @LocalServerPort
   private int port;
   
   @Autowired
   private TestRestTemplate restTemplate;
   
   @Test
   public void defaultMessage()
   {
	   assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/home",
			   String.class)).contains("This is Home Page");
   }
}
