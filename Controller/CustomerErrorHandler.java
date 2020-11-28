package com.cred.io.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

public class CustomerErrorHandler implements ResponseErrorHandler {
	
	@Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return new DefaultResponseErrorHandler().hasError(response);
    }
	
	@Override
    public void handleError(ClientHttpResponse response) throws IOException {

        if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {

            // http status code e.g. `500 INTERNAL_SERVER_ERROR`
            System.out.println(response.getStatusCode());

        } else if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {

            // http status code e.g. `404 NOT_FOUND`
            System.out.println(response.getStatusCode());
            System.out.print("Invalid Card Number");
            
        }
    }
	
	
	

}
