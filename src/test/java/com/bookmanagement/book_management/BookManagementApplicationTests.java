package com.bookmanagement.book_management;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookmanagement.book_management.model.Book;
import com.bookmanagement.book_management.repository.BMRepository;
import com.bookmanagement.book_management.service.BookService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookManagementApplicationTests {

    @Autowired
    private BookService bookService; // Ensure this uses the @MockBean below

    @MockBean
    private BMRepository bookRepo; // Mocked repository

	@Test
	public void addBookTest() {
		Book book = new Book(1L, "Harry Potter and the Philosopher's Stone",
				"J.K. Rowling", "1997-06-26", 223, "9780747532743");
	
		when(bookRepo.save(any(Book.class))).thenReturn(book);
	
		Book savedBook = bookService.addBook(book);

		assertNotNull(savedBook);
		assertEquals("Harry Potter and the Philosopher's Stone", savedBook.getTitle());
		verify(bookRepo).save(any(Book.class));
	}
	
}
