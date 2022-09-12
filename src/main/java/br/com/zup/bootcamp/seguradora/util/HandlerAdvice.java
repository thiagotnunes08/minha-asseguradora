package br.com.zup.bootcamp.seguradora.util;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HandlerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<?> handler(MethodArgumentNotValidException ex){

        List<String> menssagens = new ArrayList<>();

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrors){


            String msg = criadorDeMsg(fieldError.getField(), fieldError.getDefaultMessage());


            menssagens.add(msg);

        }

        return ResponseEntity.badRequest().body(menssagens);


    }

    private String criadorDeMsg(String campo,String menssagem) {
       return String.format("campo %s %s",campo, menssagem);
    }
}
