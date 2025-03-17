package com.bookmanagement.book_management.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.book_management.model.Book;
import com.bookmanagement.book_management.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @GetMapping("/get-all")
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Optional<Book> getBookById(@PathVariable Long id) {
            return bookService.getBookById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/update") // updates all the book attributes except for the id
    @ResponseBody
    public Book updateBook(@RequestBody Book book) {
       return bookService.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @PatchMapping("/changeValues/{id}") // updates specifiC values or attributes
    @ResponseBody
    public Book patchBook(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Book book = bookService.getBookById(id).orElse(null);
        if (book!= null) {
            updates.forEach((key, value) -> {
                if (key.equals("title")) {
                    book.setTitle((String) value);
                } else if (key.equals("author")) {
                    book.setAuthor((String) value);
                } else if (key.equals("publicationDate")) {
                    book.setPublicationDate((String) value);
                } else if (key.equals("numberOfPages")) {
                    book.setNumberOfPages((Integer) value);
                } else if (key.equals("isbn")) {
                    book.setIsbn((String) value);
                }
            });
            return bookService.updateBook(book);
        }
        return null; 
    }
}
