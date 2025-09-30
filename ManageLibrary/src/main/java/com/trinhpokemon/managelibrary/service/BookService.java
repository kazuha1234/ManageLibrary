package com.trinhpokemon.managelibrary.service;

import com.trinhpokemon.managelibrary.dto.request.BookCreationRequest;
import com.trinhpokemon.managelibrary.dto.request.BookUpdateRequest;
import com.trinhpokemon.managelibrary.entity.Book;
import com.trinhpokemon.managelibrary.repository.BookRepository;
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

    public List<Book> getBooks() {
        return bookRepository.findAll();
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
