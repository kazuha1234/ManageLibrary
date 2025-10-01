package com.trinhpokemon.managelibrary.controller;

import com.trinhpokemon.managelibrary.dto.request.BookCreationRequest;
import com.trinhpokemon.managelibrary.dto.request.BookUpdateRequest;
import com.trinhpokemon.managelibrary.entity.Book;
import com.trinhpokemon.managelibrary.service.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    Book createBook (@RequestBody @Valid BookCreationRequest request) {
        return bookService.createRequest(request);
    }

    @GetMapping
    Page<Book> getAllBooks (@RequestParam(value = "search", required = false) String searchValue, Pageable pageable) {
        return bookService.getBooks(searchValue, pageable);
    }

    @GetMapping("/{bookId}")
    Book getBook (@PathVariable String bookId) {
        return bookService.getBook(bookId);
    }

    @PutMapping("/{bookId}")
    Book updateBook (@RequestBody BookUpdateRequest request, @PathVariable String bookId) {
        return bookService.updateBook(bookId, request);
    }

    @DeleteMapping("/{bookId}")
    String deleteBook (@PathVariable String bookId) {
        bookService.deleteBook(bookId);

        return "Book deleted";
    }
}
