package com.jayesh.BookMyShow.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @ManyToOne
    private Theatre theatre;
    @OneToMany
    private List<Seat> seats;
}

//Screen M :  1   Theatre
// Screen 1 : M    Seats