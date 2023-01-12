package com.shubham.orderservice.external.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubham.orderservice.exception.CustomeException;
import com.shubham.orderservice.external.response.ErrorMessage;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomeErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper=new ObjectMapper();

        log.info("::response:", response.request().url());
        log.info("response:", response.request().headers());

        try {
            ErrorMessage errorMessage= objectMapper.readValue(response.body().asInputStream(),ErrorMessage.class);
            throw  new CustomeException(errorMessage.getMessage(),errorMessage.geter)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
