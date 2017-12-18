package io.pnt.edu.bookstore.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import io.pnt.edu.bookstore.dto.Book;
import io.pnt.edu.bookstore.service.BookService;

@Primary
@Service
public class HSqlBookServiceImpl implements BookService{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Book> findAll() {
		return jdbcTemplate.query("SELECT * FROM BOOKS", new BeanPropertyRowMapper<>(Book.class));
	}

	@Override
	public List<Book> findByName(String name) {
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
			}
		};
		return null;
	}

	@Override
	public int addBooks(Book... books) {
		// TODO Auto-generated method stub
		return 0;
	}

}
