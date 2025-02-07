package com.example.SignupBackend.Exception;


public class InvalidInputException extends RuntimeException {
  public InvalidInputException(String message) {
      super(message);
  }
}
