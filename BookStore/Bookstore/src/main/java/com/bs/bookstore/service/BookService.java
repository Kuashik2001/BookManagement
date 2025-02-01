package com.bs.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.bookstore.entity.Book;
import com.bs.bookstore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b)  // to save the object into the DB
	{
		bRepo.save(b);   // save the object
	}
}
