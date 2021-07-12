package com.rahul.rathore.book.service.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.rathore.book.service.data.entity.Book;
import com.rahul.rathore.book.service.services.BookService;


@RestController
@RequestMapping("/booklibrary")
public class BookServiceController {
	
	@Autowired
	private BookService bookService;
	

	@GetMapping("/books")
	public List<Book> getBooks(){
		Supplier<List<Book>> bookSupplier = 
				  () -> bookService.getBooks();
		return bookSupplier.get();
		
	}
	
	@GetMapping("/books/{bookId}") 
	private Book getBook(@PathVariable Long bookId)
	{
		return bookService.getBookById(bookId).get();
	}
	
	@PostMapping("/books/UpdateAvailability/{bookId}/{incrementalCount}")
	public ResponseEntity<Book> updateBookDetails(@PathVariable Long bookId,@PathVariable Long incrementalCount) {
		Book response = bookService.saveBook(bookId,incrementalCount);
		if (response == null)
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}
