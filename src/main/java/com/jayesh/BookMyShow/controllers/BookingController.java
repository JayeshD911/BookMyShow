package com.jayesh.BookMyShow.controllers;

import com.jayesh.BookMyShow.dtos.BookMovieRequestDTO;
import com.jayesh.BookMyShow.dtos.BookMovieResponseDTO;
import com.jayesh.BookMyShow.dtos.ResponseStatus;
import com.jayesh.BookMyShow.models.Booking;
import com.jayesh.BookMyShow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO requestDTO) {
        BookMovieResponseDTO responseDTO = new BookMovieResponseDTO();
        try{
            // Call bookMovie service method to process the booking
            Booking booking = bookingService.bookMovie(
                    requestDTO.getUserId(),
                    requestDTO.getShowId(),
                    requestDTO.getShowSeatIds()
            );

            responseDTO.setStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Movie booked successfully with Booking ID: " + booking.getId());
            responseDTO.setBooking(String.valueOf(booking.getId()));

        }catch(Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("Failed to book movie: " + e.getMessage());
        }
        return responseDTO;
    }
}
