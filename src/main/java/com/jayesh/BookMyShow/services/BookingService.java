package com.jayesh.BookMyShow.services;

import com.jayesh.BookMyShow.models.*;
import com.jayesh.BookMyShow.repos.BookingRepo;
import com.jayesh.BookMyShow.repos.ShowRepo;
import com.jayesh.BookMyShow.repos.ShowSeatRepo;
import com.jayesh.BookMyShow.repos.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {


    private final UserRepo userRepo;
    private final ShowRepo showRepo;
    private final ShowSeatRepo showSeatRepo;
    private final BookingAmountCalculationService bookingAmountCalculationService;
    private final BookingRepo bookingRepo;

    public BookingService(UserRepo userRepo,
                          ShowRepo showRepo,
                          ShowSeatRepo showSeatRepo,
                          BookingAmountCalculationService bookingAmountCalculationService,
                          BookingRepo bookingRepo) {
        this.userRepo = userRepo;
        this.showRepo = showRepo;
        this.showSeatRepo = showSeatRepo;
        this.bookingAmountCalculationService = bookingAmountCalculationService;
        this.bookingRepo = bookingRepo;
    }

    @Transactional (isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds){

        //Get user by userId
        Optional<User> userOptional = userRepo.findById(userId);

        //validate user
        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found with ID: " + userId);
        }

        User user = userOptional.get();

        //get show by showId
        Optional<Show> showOptional = showRepo.findById(showId);

        //validate show
        if(showOptional.isEmpty()) {
            throw new RuntimeException("Show not found with ID: " + showId);
        }

        Show show = showOptional.get();

        //get show seats by showSeatIds
       List<ShowSeat> showSeats = showSeatRepo.findAllById(showSeatIds);

        //check if seats are available
        for (ShowSeat showSeat : showSeats) {
            if(showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new RuntimeException("Show seat with ID: " + showSeat.getId() + " is not available");
            }
        }

        //mark show seats as blocked
        for (ShowSeat showSeat : showSeats) {
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            showSeatRepo.save(showSeat);
        }

        //create booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(showSeats);
        booking.setBookingDate(new Date());
        booking.setBookingStatus(BookingStatus.SUCCESS);
        booking.setShowSeats(showSeats);
        booking.setAmount(bookingAmountCalculationService.calculateBookingAmount(showSeats));

        // save booking
        bookingRepo.save(booking);

        // Payment processing
        // Mark seats as available if payment fails

        return booking;
    }
}
