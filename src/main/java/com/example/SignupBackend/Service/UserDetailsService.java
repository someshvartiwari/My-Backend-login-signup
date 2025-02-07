package com.example.SignupBackend.Service;

import org.springframework.stereotype.Service;

import com.example.SignupBackend.Model.LoginDetailes;
import com.example.SignupBackend.Model.ResponseMessage;
import com.example.SignupBackend.Model.UserDetails;

@Service
public interface UserDetailsService {

public UserDetails saveuserdetails(UserDetails userdetails);

public ResponseMessage validate_login(LoginDetailes logindetails);


  
}
