package com.jayesh.BookMyShow.models;


import java.util.List;

public class User extends BaseModel{
    public String name;
    public String email;
    public String password;
    public List<Booking> bookings;
}

// User   1 : M   Booking