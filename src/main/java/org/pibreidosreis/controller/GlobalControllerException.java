package org.pibreidosreis.controller;

import org.pibreidosreis.controller.vnd.Embedded;
import org.pibreidosreis.controller.vnd.VndError;
import org.pibreidosreis.controller.vnd.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalControllerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public VndErrors processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<VndError> vndErrors = fieldErrors.stream().map(fieldError -> new VndError("INVALID", fieldError.getDefaultMessage(),
                fieldError.getField())).collect(Collectors.toList());
        return new VndErrors(new Embedded(vndErrors));
    }
}
