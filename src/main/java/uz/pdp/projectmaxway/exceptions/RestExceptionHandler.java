package uz.pdp.projectmaxway.exceptions;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.ErrorCode;

import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(RestExeption.class)
    public HttpEntity<ApiResponse<List<ErrorCode>>> exceptionHandler(RestExeption e){
        return new ResponseEntity<>(
                ApiResponse.failResponse(
                        e.getMessage(),
                        e.getStatus().value()
                ),
                e.getStatus()
        );
    }

}
