package com.odnzk.study.config;


import com.odnzk.study.exception.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Log4j2
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UnknownException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleException(UnknownException ex) {
        return createModelAndView(ex);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityDoesNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleNotFound(EntityNotFoundException ex) {
        return createModelAndView(ex);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConvertingExceptionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleConverting(ConvertingExceptionException ex) {
        return createModelAndView(ex);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmailSendingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleEmailSending(EmailSendingException ex) {
        return createModelAndView(ex);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleAlreadyExist(AlreadyExistsException ex) {
        return createModelAndView(ex);
    }

    private ModelAndView createModelAndView(Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("error", ex.getMessage());
        return mav;
    }
}
