package com.trinhpokemon.managelibrary.repository;

import com.trinhpokemon.managelibrary.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    boolean existsByTitle(String title);
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
