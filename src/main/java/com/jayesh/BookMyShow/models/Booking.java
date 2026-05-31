package com.jayesh.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private User user;
    private Date bookingDate;
    @OneToMany
    private List<Payment> payments;
    @ManyToOne
    private Show show;
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @OneToMany
    private List<ShowSeat> showSeats;
    private int amount;
}

// Cardinality:
//User  1 : M      Booking
// Booking  1 : M    Payments
// Bookign M : 1  SHow

// Sign up a user