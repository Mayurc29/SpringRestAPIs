package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServicesImpl implements CourseServices
{

	@Autowired
	private CourseDao courseDao;
	@Override
	public List<Course> getCourses() {

		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId) {
        
		//return courseDao.getById(courseId);
		try {
			return courseDao.getReferenceById(courseId);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Course addCourse(Course course)
	{
		courseDao.save(course);
		return course;
	}

	public Course updateCourse(Course course)
	{
		courseDao.save(course);
		return course; 
	}

	@Override
	public void deleteCourse(long parselong)
	{
		
		Course entity = courseDao.getReferenceById(parselong);
		
		courseDao.delete(entity);
		
		
	}
	
	
	//-----------------------------
	/*List<Course>list;
	
	public CourseServicesImpl()
	{
       	list = new  ArrayList<>();
		list.add(new Course(1,"Core Java Course","This Course Contains basics of Java"));
		list.add(new Course(2,"Spring Course","This Course Contains Spring boot basics"));
		
		
	}
	
	
	@Override
	public List<Course> getCourses() {

		return list;
	}

	@Override
	public Course getCourse(long courseId) {
        
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c = course;
				break;
			}
			
		}
		return c;
	}


	//add course
	@Override
	public Course addCourse(Course course)
	{
		list.add(course);
		return course;
	}


	//update Course
	@Override
	public Course updateCourse(Course course)
	{
		list.forEach(e ->
		{
			if(e.getId() ==course.getId())
			{
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course; 
	}


	@Override
	public void deleteCourse(long parselong)
	{
		list = this.list.stream().filter(e->e.getId()!= parselong).collect(Collectors.toList());
		
	}
	-----------------------------------------------------*/

	


}
