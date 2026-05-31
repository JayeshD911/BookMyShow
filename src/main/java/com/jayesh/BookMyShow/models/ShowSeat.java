package com.jayesh.BookMyShow.models;


import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(value = EnumType.STRING)
    private ShowSeatStatus status;
    private Date blockedAt;
}

// Showseat M : 1    Show
// Showseat M : 1    Seat
