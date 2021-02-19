package com.example.demo.infrastructure;


import com.example.demo.application.Response;
import com.example.demo.application.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(RestControllerExceptionHandler.class);


    private Response createErrorResponse(String message) {
        Response response = new Response();
        response.setStatus(ResponseStatus.FAILURE.name());
        response.setErrorMessage(message);
        return response;
    }
}
