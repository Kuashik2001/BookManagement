package com.bs.bookstore.controller;

import java.util.List;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bs.bookstore.entity.Book;
import com.bs.bookstore.entity.MyBookList;
import com.bs.bookstore.service.BookService;
import com.bs.bookstore.service.MyBookListService;



@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
//	@GetMapping("/available_books")
//	public String getAllBook()
//	{
//		return "bookList";
//	}
	// This method we were using for only redirecting and not showing the data from database
	
	// Now we want to send the data from controller to view so we will add ModelAndView return type
	@GetMapping("/available_books")
	public ModelAndView getAllBook()
	{
		List<Book> list=service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);  In one line
		return new ModelAndView("bookList","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		service.save(b);
		return "redirect:/available_books";
	}
	@GetMapping("/my_Books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id)
	{
		Book b=service.getBookByID(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
}
