package com.spring.jdbc.Dao;

import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.Entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	public int insert(Student student) {
		// TODO Auto-generated method stub
		
		
		
		String query= "insert into table1(tId,tCity,tName) values(?,?,?)";
		int result = this.jdbcTemplate.update(query,student.getId(),student.getCity(),student.getName());
		
		
		return result;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int update(Student student) {
		// TODO Auto-generated method stub
		String query="update table1 set tName=?, tCity=? where tId=?";
		int result=jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		
		return result;
		
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		String query= "delete from table1 where tId=?";
		jdbcTemplate.update(query,id);
		System.out.println("done");
		
	}
	public Student getData(int id) {
		
		String query ="select* from table1 where tId>?";
		RowMapper<Student> rowMapper= new RowMapperImpl();
		Student student= this.jdbcTemplate.queryForObject(query,rowMapper,id);
		
		return student;
	}
	public List<Student> getAllData(int id) {
		// TODO Auto-generated method stub
		
		String query="select * from table1 where tId> ?";
		RowMapper<Student> rMaper= new RowMapperImpl();
		
		List<Student> students = this.jdbcTemplate.query(query,rMaper,id);
		
		
		return students;
	}
	

}
