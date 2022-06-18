package com.spring.jdbc.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.Entities.Student;

public class RowMapperImpl implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student= new Student();
		student.setId(rs.getInt(1));
		student.setCity(rs.getString(3));
		student.setName(rs.getString(2));
		
		return student;
	}

}
