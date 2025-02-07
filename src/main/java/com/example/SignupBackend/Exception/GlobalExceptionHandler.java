package com.example.SignupBackend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.SignupBackend.Model.ResponseMessage;

@ControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ResponseMessage> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        return new ResponseEntity<>(new ResponseMessage(ex.getMessage(), false), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ResponseMessage> handleInvalidInput(InvalidInputException ex) {
        return new ResponseEntity<>(new ResponseMessage(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(new ResponseMessage("An unexpected error occurred: " + ex.getMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
    }

  
}
