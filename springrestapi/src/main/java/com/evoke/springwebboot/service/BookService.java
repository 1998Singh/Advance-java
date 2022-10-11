package com.evoke.springwebboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.springwebboot.dao.BookRepository;
import com.evoke.springwebboot.model.Book;

@Component
public class BookService {
	@Autowired
	private BookRepository bookRepository;

//	private static List<Book> list = new ArrayList<Book>();
//	static {
//
//		list.add(new Book(1, "Java For Beginners", "Dr.M.P.Vani"));
//		list.add(new Book(2, "Advance Java ", "Vijay Patil"));
//		list.add(new Book(3, "Advance Java Programming", "E.Ramaraj"));
//	}

	// get All Books
	public List<Book> getAllBooks() {

		List<Book> list = (List<Book>) this.bookRepository.findAll();

		return list;
	}

	// get book by id
	public Book getBookById(int id) {
		Book book = null;
		// book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		book = this.bookRepository.findById(id);
		return book;

	}

	// Adding New Book in list
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}

	// Delete Book detail by id
	public void deleteBook(int id) {
		// list = list.stream().filter(book -> book.getId() !=
		// id).collect(Collectors.toList());
		bookRepository.deleteById(id);
	}

	// update book detail

	public void updateBook(Book book, int id) {
//		list = list.stream().map(b -> {
//			if (b.getId() == id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(id);
		bookRepository.save(book);
	}
}
