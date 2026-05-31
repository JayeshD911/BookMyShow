package com.jayesh.BookMyShow.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Region extends BaseModel {
    private String name;
    @OneToMany
    private List<Theatre> theatres;
}

// Region 1 : M  Theatres