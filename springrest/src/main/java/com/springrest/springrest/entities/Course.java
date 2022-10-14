package com.springrest.springrest.entities;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.springrest.springrest.config.AESEncryption;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

public class Course 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    @Convert(converter = AESEncryption.class)
	private String title;
	
    @Convert(converter = AESEncryption.class)
	private String description;
    
    
    
	public Course(int id, String title, String description) 
	{
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public Course()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
}
