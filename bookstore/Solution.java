package com.bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your choice");
		int choice = Integer.valueOf(bf.readLine());
		switch (choice) {
		case 1:
			Ebook ebook = new Ebook();
			ebook.setBookId(1);
			ebook.setTitle("naveen1");
			ebook.setPrice(12.431);
			ebook.setIsbn("tar1");
			ebook.setPublisher("gsdf1");
			ebook.setEdition("20171");
			ebook.setDownloadUrl("www.book.com1");
			ebook.setSize(121);
			session.save(ebook);
			Ebook ebook1 = new Ebook();
			ebook1.setBookId(2);
			ebook1.setTitle("naveen");
			ebook1.setPrice(12.43);
			ebook1.setIsbn("tar");
			ebook1.setPublisher("gsdf");
			ebook1.setEdition("2017");
			ebook1.setDownloadUrl("www.book.com");
			ebook1.setSize(12);
			session.save(ebook1);
			Author author = new Author();
			author.setAuthorId(11);
			author.setAuthorName("sachin");
			author.setEmail("gdfgdf");
			author.setGender("male");
			author.setWebUrl("gfdsg");
			session.save(author);
			author.getBook().add(ebook);
			author.getBook().add(ebook1);
			ebook.setAuthor(author);
			ebook1.setAuthor(author);
			break;
		default:
			System.out.println("Enter the correct option");
		}
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
