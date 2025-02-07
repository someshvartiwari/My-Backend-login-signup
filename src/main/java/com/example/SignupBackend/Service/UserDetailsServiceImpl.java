package com.example.SignupBackend.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SignupBackend.Model.LoginDetailes;
import com.example.SignupBackend.Model.ResponseMessage;
import com.example.SignupBackend.Model.UserDetails;
import com.example.SignupBackend.Repository.UserDetailsRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserDetailsRepo userdetailsrepo;

public UserDetails saveuserdetails(UserDetails userdetails){
   return userdetailsrepo.save(userdetails);
}


public ResponseMessage validate_login(LoginDetailes logindetails){
Optional<UserDetails> user = userdetailsrepo.findById(logindetails.getEmail());
if(user.isPresent())
{
  if(user.get().getEmail().equals(logindetails.getEmail()) && user.get().getPassword().equals(logindetails.getPassword())){
    return new ResponseMessage("Login Successfull", true);   
}
return new ResponseMessage("Invalid Credentials",false);
}
 return new ResponseMessage("Email doesn't Exists",false); 
}

}
