package com.spring.jdbc;
// Configuration using java File

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Dao.StudentDaoImpl;

@Configuration
public class JavaConfig {
	
	@Bean(name = {"ds"})
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/student");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		
		return dataSource;
		
	}
	
	@Bean(name = {"jdbctemplate"})
	public JdbcTemplate getJdbcTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate;
	}
	
	@Bean(name = {"studentDaoImp"})
	public StudentDao getStudentDao() {
		
		
		StudentDaoImpl studentDao= new StudentDaoImpl();
		studentDao.setJdbcTemplate(getJdbcTemplate());
		return studentDao;
	}
	
}
