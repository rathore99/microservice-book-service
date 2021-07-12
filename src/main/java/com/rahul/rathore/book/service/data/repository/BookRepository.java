package com.rahul.rathore.book.service.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.rathore.book.service.data.entity.Book;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{

}
