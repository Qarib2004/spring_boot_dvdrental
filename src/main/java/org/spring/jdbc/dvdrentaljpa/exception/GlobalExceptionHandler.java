package org.spring.jdbc.dvdrentaljpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleAllExceptions(Exception ex, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "An unexpected error occurred: " + ex.getMessage());
        mav.setViewName("error"); // error.html должен находиться в /src/main/resources/templates
        return mav;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Invalid input: " + ex.getMessage());
        mav.setViewName("error"); // error.html должен находиться в /src/main/resources/templates
        return mav;
        
    }
}
