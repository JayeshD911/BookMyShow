package com.jayesh.BookMyShow.controllers;

import com.jayesh.BookMyShow.dtos.ResponseStatus;
import com.jayesh.BookMyShow.dtos.SignUpUserRequestDTO;
import com.jayesh.BookMyShow.dtos.SignUpUserResponseDTO;
import com.jayesh.BookMyShow.models.User;
import com.jayesh.BookMyShow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpUserResponseDTO signUpUser(SignUpUserRequestDTO request) {
        SignUpUserResponseDTO respose = new SignUpUserResponseDTO();
        try{
            User user = userService.signUpUser(request.getName(), request.getEmail(), request.getPassword());
            respose.setMessage("User signed up successfully with ID: " + user.getId());
            respose.setStatus(ResponseStatus.SUCCESS);
            respose.setUserId(user.getId());

        }catch(Exception ex){
            // Handle exception
            respose.setMessage("Failed to sign up user: " + ex.getMessage());
            respose.setStatus(ResponseStatus.FAILURE);
        }
        return respose;
    }
}
