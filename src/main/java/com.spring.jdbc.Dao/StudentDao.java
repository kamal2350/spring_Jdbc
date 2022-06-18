// Interface
package com.spring.jdbc.Dao;

import java.util.List;

import com.spring.jdbc.Entities.Student;

public interface StudentDao {
	
	public int insert(Student student);
	public int update(Student student);
	public void delete(int id);
	public Student getData(int id);
	public List<Student> getAllData(int id);
	
}
