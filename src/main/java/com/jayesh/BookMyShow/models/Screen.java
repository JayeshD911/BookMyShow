package com.jayesh.BookMyShow.models;



import java.util.List;

public class Screen extends BaseModel{
    private String name;

    private Theatre theatre;

    private List<Seat> seats;
}

//Screen M :  1   Theatre
// Screen 1 : M    Seats