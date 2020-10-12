package com.javatodev.api.client.config;

import com.javatodev.api.exception.FeignClientException;
import com.javatodev.api.exception.config.GlobalErrorCode;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignCustomErrorDecoder implements ErrorDecoder {
    @Override public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                //handle exception
                return new FeignClientException("exception.feign.client.communication", GlobalErrorCode.ERROR_FEIGN_CLIENT);
            case 401:
                //handle exception
                return new FeignClientException("exception.feign.client.communication", GlobalErrorCode.ERROR_FEIGN_CLIENT);
            case 404:
                //handle exception
                return new FeignClientException("exception.feign.client.communication", GlobalErrorCode.ERROR_FEIGN_CLIENT);
            default:
                //handle exception
                return new FeignClientException("exception.feign.client.communication", GlobalErrorCode.ERROR_FEIGN_CLIENT);
        }
    }
}
