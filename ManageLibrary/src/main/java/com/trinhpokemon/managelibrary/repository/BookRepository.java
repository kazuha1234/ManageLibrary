package com.trinhpokemon.managelibrary.repository;

import com.trinhpokemon.managelibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    boolean existsByTitle(String title);
}
