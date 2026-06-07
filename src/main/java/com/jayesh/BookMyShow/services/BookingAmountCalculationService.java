package com.jayesh.BookMyShow.services;

import com.jayesh.BookMyShow.models.Show;
import com.jayesh.BookMyShow.models.ShowSeat;
import com.jayesh.BookMyShow.models.ShowSeatType;
import com.jayesh.BookMyShow.repos.ShowSeatTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingAmountCalculationService {
    private final ShowSeatTypeRepo showSeatTypeRepo;

    public BookingAmountCalculationService(ShowSeatTypeRepo showSeatTypeRepo) {
        this.showSeatTypeRepo = showSeatTypeRepo;
    }

    public int calculateBookingAmount(List<ShowSeat> showSeats) {
        int amount = 0;
        Show show = showSeats.get(0).getShow();

        List<ShowSeatType> ShowSeatTypes = showSeatTypeRepo.findByShow(show);
        for(ShowSeat showSeat : showSeats) {
            for(ShowSeatType showSeatType : ShowSeatTypes) {
                if(showSeatType.getSeatType().getId() == showSeat.getSeat().getSeatType().getId()) {
                    amount += showSeatType.getPrice();
                    break; // no need to check other seat types for this show seat once we found the matching seat type
                }
            }
        }

        return amount;
    }
}
