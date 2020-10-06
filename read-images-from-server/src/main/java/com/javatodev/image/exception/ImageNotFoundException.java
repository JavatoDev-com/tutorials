package com.javatodev.image.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Image Not Found")
public class ImageNotFoundException extends RuntimeException{
}
