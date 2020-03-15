package com.tistory.jaimemin.RestaurantService.interfaces;

import com.tistory.jaimemin.RestaurantService.application.EmailNotExistingException;
import com.tistory.jaimemin.RestaurantService.application.WrongPasswordException;
import com.tistory.jaimemin.RestaurantService.domain.RestaurantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SessionErrorHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongPasswordException.class)
    public String handleWrongPassword() {
        return "{}";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailNotExistingException.class)
    public String handleEmailNotExisting() {
        return "{}";
    }
}
