package com.revoluteai.helpers;

import com.revoluteai.exceptions.InvalidSalaryPercentage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHelper {

    @ExceptionHandler(value = { InvalidSalaryPercentage.class })
    @ResponseBody
    protected ResponseEntity<Object> invalidSalaryPercentage(InvalidSalaryPercentage invalidSalaryPercentage) {
        return buildResponseEntity(new ApiResponse(400,invalidSalaryPercentage.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiResponse apiResponse) {
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }


}
