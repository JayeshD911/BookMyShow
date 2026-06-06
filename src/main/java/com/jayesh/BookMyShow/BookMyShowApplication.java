package com.jayesh.BookMyShow;

import com.jayesh.BookMyShow.controllers.UserController;
import com.jayesh.BookMyShow.dtos.SignUpUserRequestDTO;
import com.jayesh.BookMyShow.dtos.SignUpUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {
	@Autowired
	UserController userController;

	@Override
	public void run(String... args) throws Exception {
		SignUpUserRequestDTO request = new SignUpUserRequestDTO();
		request.setName("Jayesh");
		request.setEmail("jaydec1997@gmail.com");
		request.setPassword("password");
		SignUpUserResponseDTO response= userController.signUpUser(request);
		System.out.println(response.getMessage());
		System.out.println(response.getStatus());
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

}
