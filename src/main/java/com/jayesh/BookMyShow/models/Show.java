package com.jayesh.BookMyShow.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Theatre theatre;
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private Movie movie;
    private String startTime;
    private String endTime;
    private Date showDate;
    @OneToMany
    private List<ShowSeat> seats;
    @OneToMany
    private List<ShowSeatType> seatTypes;

}

// Show M : 1    Movie
