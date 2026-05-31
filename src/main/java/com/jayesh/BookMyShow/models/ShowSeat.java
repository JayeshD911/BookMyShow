package com.jayesh.BookMyShow.models;


import java.util.Date;

public class ShowSeat extends BaseModel{
    private Show show;
    private Seat seat;
    private ShowSeatStatus status;
    private Date blockedAt;
}

// Showseat M : 1    Show
// Showseat M : 1    Seat
