package com.microservices.OrderService.External.Decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.OrderService.Exception.CustomException;
import com.microservices.OrderService.External.Response.ErrorResponse;
import com.microservices.OrderService.Service.OrderServiceImpl;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class CustomErrorDecoder implements ErrorDecoder {
    private static final Logger logger = Logger.getLogger(CustomErrorDecoder.class.getName());
    @Override
    public Exception decode(String s, Response response) {
        logger.info(response.request().url());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(),ErrorResponse.class);
            return new CustomException(errorResponse.getMessage(),errorResponse.getErrorCode(),response.status());
        } catch (IOException e) {
            return new CustomException("Product does not have sufficient Quantity", "INSUFFICIENT QUANTITY",500);
        }

    }
}
