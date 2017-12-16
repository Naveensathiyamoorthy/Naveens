package com.bookstore;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ebook")
public class Book {
	@Id
	@Column(name = "bookId")
	private int bookId;
	@Column
	private String title;
	@Column
	private double price;
	@Column
	private String isbn;
	@Column
	private String publisher;
	@Column
	private String Edition;

	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return Edition;
	}

	public void setEdition(String edition) {
		Edition = edition;
	}

}
