package com.trinhpokemon.managelibrary.dto.request.Book.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreationRequest {
    @Size(min = 3, max = 50, message = "Title must be at least 3 characters and greatest 50 characters")
    private String title;
    @Size(min = 3, max = 50, message = "Title must be at least 3 characters and greatest 50 characters")
    private String author;
    @Digits(integer = 4, fraction = 0, message = "Publish year must be a 4-digit number")
    @Positive(message = "Publish year must be a positive number")
    private int publishedYear;
    @Digits(integer = 4, fraction = 0, message = "Quantity must be a 4-digit number")
    @Positive(message = "Publish year must be a positive number")
    private int quantity;
}

