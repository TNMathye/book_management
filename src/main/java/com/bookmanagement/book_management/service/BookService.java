package com.bookmanagement.book_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanagement.book_management.model.Book;
import com.bookmanagement.book_management.repository.BMRepository;

@Service
public class BookService {
    
    private BMRepository bookRepo;
    
    public BookService(BMRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getBooks() {
        return bookRepo.findAll();    
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);    
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);    
    }

    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    public String deleteBookById(Long id) {
        try {
            bookRepo.deleteById(id);
            return "Book deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
