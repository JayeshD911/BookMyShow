package com.jayesh.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private int price;
}

// ShowSeatType M : 1  Show
// ShowSeatType M : 1   SeatType

// Silver
// Gold
// Platinum

// 1  Silver  200
// 1  Gold    300
// 1  Platinum 400
// 2  Silver  250
// 2  Gold    350