package com.example.SignupBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SignupBackend.Model.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, String> {

  

  
}
