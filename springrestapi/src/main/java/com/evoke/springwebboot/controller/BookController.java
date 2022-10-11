package com.evoke.springwebboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.springwebboot.model.Book;
import com.evoke.springwebboot.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookservice;

//	@GetMapping("/book")
//	public String getBook() {
//		return "This is Form Book Method ";
//	}

//	@GetMapping("/books")
//	public Book getBooks() {
//
//		Book book = new Book();
//		book.setId(1);
//		book.setTitle("Spring FrameWork With Java");
//		book.setAuthor("B.Mohamed Ibrahim");
//		return book;
//
//	}

	// Get All Books From List
	@GetMapping("/books")
	public List<Book> getBooks2() 
	{

		return this.bookservice.getAllBooks();
	}

	// View Book Details By id
	@GetMapping("/books/{id}")
	public Book getBookid(@PathVariable("id") int id) {

		return this.bookservice.getBookById(id);
	}

	// Adding New Book in List
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookservice.addBook(book);
		return b;
	}

	// Delete book details by id
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		this.bookservice.deleteBook(id);
	}

	// update book detail
	@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		
		this.bookservice.updateBook(book, id);
		return book;
	}

}
