package com.rahul.rathore.book.service.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {
	
	@Id
	@Column(name="BOOK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookId;
	
	@Column(name="BOOK_NAME")
	private String bookName;
	
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(long availableCopies) {
		this.availableCopies = availableCopies;
	}

	public long getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(long totalCopies) {
		this.totalCopies = totalCopies;
	}

	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="AVAILABLE_COPIES")
	private long availableCopies;
	
	@Column(name="TOTAL_COPIES")
	private long totalCopies;



	
	

}
