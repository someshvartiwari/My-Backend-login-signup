package com.example.SignupBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SignupBackend.Exception.InvalidInputException;
import com.example.SignupBackend.Exception.UserAlreadyExistsException;
import com.example.SignupBackend.Model.LoginDetailes;
import com.example.SignupBackend.Model.ResponseMessage;
import com.example.SignupBackend.Model.UserDetails;
import com.example.SignupBackend.Service.UserDetailsService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/user")
@RestController
public class UserDetailsController {

  @Autowired
  UserDetailsService userdetailsservice;

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/signup")
  public ResponseEntity<ResponseMessage> saveUserDetails(@RequestBody UserDetails userDetails) {
      try {
          UserDetails userSaved = userdetailsservice.saveuserdetails(userDetails);
          return new ResponseEntity<>(new ResponseMessage("User saved successfully", true), HttpStatus.CREATED);
      } catch (UserAlreadyExistsException e) {
          return new ResponseEntity<>(new ResponseMessage(e.getMessage(), false), HttpStatus.CONFLICT);
      } catch (InvalidInputException e) {
          return new ResponseEntity<>(new ResponseMessage(e.getMessage(), false), HttpStatus.BAD_REQUEST);
      } catch (Exception e) {
          return new ResponseEntity<>(new ResponseMessage("An unexpected error occurred", false), HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<ResponseMessage> login(@RequestBody LoginDetailes loginDetails) {
        try {
            ResponseMessage response = userdetailsservice.validate_login(loginDetails);
            // System.out.println(response);
            // Return appropriate HTTP response based on the service response
            if (response.isSuccess()) {
                return new ResponseEntity<>(response, HttpStatus.OK); // Login successful
            } else {
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED); // Invalid credentials or email not found
            }
        } catch (Exception e) {
            // Handle unexpected exceptions
            return new ResponseEntity<>(new ResponseMessage("An unexpected error occurred", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

