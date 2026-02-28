package com.rapidrise.task1.exception;

import com.rapidrise.task1.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // 🔹 Helper Method (Common Builder)
    private ResponseEntity<ResponseStructure<String>> buildResponse(
            String message, HttpStatus status) {

        ResponseStructure<String> res = new ResponseStructure<>();
        res.setStatus(status.value());
        res.setMessage("Failure");
        res.setData(message);

        return new ResponseEntity<>(res, status);
    }

    // 🔹 Invalid Credentials
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ResponseStructure<String>> handleInvalidCredentials(
            InvalidCredentialsException ex) {

        return buildResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    // 🔹 Invalid Token
    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ResponseStructure<String>> handleInvalidToken(
            InvalidTokenException ex) {

        return buildResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    // 🔹 Division by Zero
    @ExceptionHandler(DivisionByZeroException.class)
    public ResponseEntity<ResponseStructure<String>> handleDivisionByZero(
            DivisionByZeroException ex) {

        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
