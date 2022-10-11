package com.evoke.springwebboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.evoke.springwebboot.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findById(int id);

}
