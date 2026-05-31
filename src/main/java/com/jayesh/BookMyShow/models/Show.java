package com.jayesh.BookMyShow.models;

import java.util.Date;
import java.util.List;


public class Show extends BaseModel{

    private Theatre theatre;
    private Screen screen;
    private Movie movie;
    private String startTime;
    private String endTime;
    private Date showDate;
    private List<ShowSeat> seats;
    private List<ShowSeatType> seatTypes;

}

// Show M : 1    Movie
