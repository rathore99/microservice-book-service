package com.rahul.rathore.book.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rahul.rathore.book.service.data.entity.Book;
import com.rahul.rathore.book.service.data.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepository;
	@Value("${microservice.changes.value}")
	private String testChanges;
	

	public Book saveBook(Long bookId,Long incrementalCount) {
		if(bookId!=null && incrementalCount!=null)
		return validations(bookId,incrementalCount);
		return null;
	}

	public Optional<Book> getBookById(Long bookId) {
		return bookrepository.findById(bookId);
	}

	public List<Book> getBooks() {
		System.out.println("@@@@@@@@@@@ "+ testChanges);
		return bookrepository.findAll();
	}

	public Book validations(Long bookId,Long incrementalCount) {
		Book updatedBookEntry;
		Optional<Book> bookOp = bookrepository.findById(bookId);
		Book book = bookOp.get();

		if (book != null) {
			System.out.println("Inside validation book is not null "+ book +" value " + incrementalCount);
			Long availableCopies = book.getAvailableCopies() + incrementalCount;

			if (availableCopies <= book.getTotalCopies() && availableCopies>-1 ) {
				book.setAvailableCopies(availableCopies);
				updatedBookEntry = bookrepository.save(book);
				return updatedBookEntry;
			}
		}

		return book;

	}

}
