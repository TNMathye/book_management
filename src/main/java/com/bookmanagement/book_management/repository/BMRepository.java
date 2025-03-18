package com.bookmanagement.book_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookmanagement.book_management.model.Book;

@Repository
public interface BMRepository extends JpaRepository<Book, Long> {
    
}
