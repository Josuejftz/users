package org.example.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //1. Esto le dice a spring: "cualquier error en los controlares, tráemelo aqui"
public class GlobalExceptionHandler {
    //2. @ExceptionHandler: Especificamente, quiero manejar errores de validación (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errores = new HashMap<>();

        //3. Recorremos todos los errores que encontró Spring
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String nombreCampo = ((FieldError) error).getField();// Ej: "email"
            String mensajeError = error.getDefaultMessage();// Ej: "El email debe ser válido"
            errores.put(nombreCampo,mensajeError);
        });

        //4. Devolvemos un 400 Bad request con el mapa limpio
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }

}
