package com.example.SignupBackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class UserDetails {

  private String firstname;

  private String lastname;

  private String dob;

  private String gender;

  @Id
  private String email;

  private String password;
  
  private String country;

  private Long mobilenumber;
  
}
