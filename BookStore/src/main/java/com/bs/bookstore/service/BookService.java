package com.bs.bookstore.service;

import java.util.List;

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
	
	public List<Book> getAllBook() // To display the list of the data in the application_books
	{
		return bRepo.findAll(); // To fetch all the records from the database or findById() to fetch a particular data
	}
	public Book getBookByID(int id)
	{
		return bRepo.findById(id).get();
	}
}
