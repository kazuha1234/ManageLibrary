package com.trinhpokemon.managelibrary.dto.request.Book.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateRequest {
    private String title;
    private String author;
    private int publishedYear;
    private int quantity;
}
