package com.jayesh.BookMyShow.models;

import java.util.List;

public class Theatre extends BaseModel{
    private String name;
    private String address;
    private Region region;
    private List<Screen> screens;
}

// Theatre 1 : M  Screens
