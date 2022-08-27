package com.evoke.springwebboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.evoke.springwebboot.model.Book;

@Component
public class BookService {

	private static List<Book> list = new ArrayList<Book>();
	static {

		list.add(new Book(1, "Java For Beginners", "Dr.M.P.Vani"));
		list.add(new Book(2, "Advance Java ", "Vijay Patil"));
		list.add(new Book(3, "Advance Java Programming", "E.Ramaraj"));
	}

	// get All Books
	public List<Book> getAllBooks() {
		return list;
	}

	// get book by id
	public Book getBookById(int id) {
		Book book = null;
		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		return book;

	}

	// Adding New Book in list
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	// Delete Book detail by id
	public void deleteBook(int id) {
		list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
	}

	// update book detail

	public void updateBook(Book book, int id) {
		list = list.stream().map(b -> {
			if (b.getId() == id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
