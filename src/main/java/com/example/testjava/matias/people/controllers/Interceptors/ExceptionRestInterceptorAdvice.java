package com.example.testjava.matias.people.controllers.Interceptors;

import com.example.testjava.matias.people.model.dto.ErrorResponseDTO;
import com.example.testjava.matias.people.utils.ConstantUtils;
import com.example.testjava.matias.people.utils.exceptions.BusinessLogicException;
import com.example.testjava.matias.people.utils.exceptions.RutConverterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionRestInterceptorAdvice {

    private static Logger log = LoggerFactory.getLogger(ExceptionRestInterceptorAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> exceptionHandler(Exception ex) {
        log.error("Internal error: ", ex);
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setErrorType("InternalError");
        error.setMessage(ConstantUtils.MSJ_INTERNAL_ERROR);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<ErrorResponseDTO> BusinessLogicHandler(BusinessLogicException ex) {
        log.debug("Business Logic Exception: ", ex);
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setErrorType(ex.getClass().getSimpleName());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RutConverterException.class)
    public ResponseEntity<ErrorResponseDTO> RutConverterHandler(RutConverterException ex) {
        log.debug("Rut Converted Exception: ", ex);
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setErrorType(ex.getClass().getSimpleName());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
