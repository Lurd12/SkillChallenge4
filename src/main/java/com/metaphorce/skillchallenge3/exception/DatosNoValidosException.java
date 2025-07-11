package com.metaphorce.skillchallenge3.exception;

import org.springframework.validation.BindingResult;

public class DatosNoValidosException extends RuntimeException  {
    private BindingResult bindingResult;
    public DatosNoValidosException(String message, BindingResult bindingResult) {
        super(message);
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }


}
