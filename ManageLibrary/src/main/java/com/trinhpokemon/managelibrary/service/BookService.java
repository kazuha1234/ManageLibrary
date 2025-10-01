package com.trinhpokemon.managelibrary.service;

import com.trinhpokemon.managelibrary.dto.request.BookCreationRequest;
import com.trinhpokemon.managelibrary.dto.request.BookUpdateRequest;
import com.trinhpokemon.managelibrary.entity.Book;
import com.trinhpokemon.managelibrary.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createRequest(BookCreationRequest request) {
        Book book = new Book();

        if(bookRepository.existsByTitle(request.getTitle())) {
            throw new RuntimeException("Title already exists");
        }

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublishedYear(request.getPublishedYear());
        book.setQuantity(request.getQuantity());

        return bookRepository.save(book);
    }

//    Dont have pagination
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

//    Have pagination
    public Page<Book> getBooks(String searchValue, Pageable pageable) {
        Page<Book> list;

        if(searchValue == null || searchValue.isEmpty()) {
            list = bookRepository.findAll(pageable);
        } else {
            list = bookRepository.findByTitleContainingIgnoreCase(searchValue, pageable);
        }

        return list;
    }

    public Book getBook(String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book updateBook(String id, BookUpdateRequest request) {
        Book book = getBook(id);

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublishedYear(request.getPublishedYear());
        book.setQuantity(request.getQuantity());

        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}
