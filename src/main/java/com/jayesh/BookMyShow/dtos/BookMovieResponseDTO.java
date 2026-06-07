package com.jayesh.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDTO {
    private String message;
    private String booking;
    private ResponseStatus status;
}
