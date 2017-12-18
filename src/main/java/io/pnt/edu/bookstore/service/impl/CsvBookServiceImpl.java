package io.pnt.edu.bookstore.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import io.pnt.edu.bookstore.dto.Book;
import io.pnt.edu.bookstore.service.BookService;

@Service("csvBookServiceImpl")
public class CsvBookServiceImpl implements BookService{
	private List<Book> booksList = new ArrayList<>();
	private Logger log = LoggerFactory.getLogger(CsvBookServiceImpl.class);
	
	@PostConstruct
	public void init() {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\books.csv"),"utf-8"));
		
		String str = null;
		while((str = in.readLine()) !=null) {
			String[] row =str.split(",");
			
			booksList.add(
					Book.builder()
					.title(row[1])
					.author(row[2])
					.publisher(row[3])
					.price(Double.parseDouble(row[4]))
					);
			
		}
	}

	@Override
	public List<Book> findAll() {
		return bookList;
	}

	@Override
	public List<Book> findByName(String name) {
		return booksList.stream()
				.filter(b -> b.getTitle().contains(name))
				.collect(Collectors.toList());
	}

	@Override
	public int addBooks(Book... books) {
		// TODO Auto-generated method stub
		return 0;
	}

}
