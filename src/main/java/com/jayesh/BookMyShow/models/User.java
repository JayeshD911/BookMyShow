package com.jayesh.BookMyShow.models;


import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    public String name;
    public String email;
    public String password;
    @OneToMany
    public List<Booking> bookings;
}

// User   1 : M   Booking