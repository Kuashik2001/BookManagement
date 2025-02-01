package com.bs.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bs.bookstore.entity.MyBookList;
import com.bs.bookstore.repository.MyBookResository;

@Service
public class MyBookListService {
	
	private MyBookResository mybook;
	public void saveMyBooks(MyBookList book)
	{
		mybook.save(book);
	}
	public List<MyBookList> getAllMyBooks()
	{
		return mybook.findAll();
	}
}
