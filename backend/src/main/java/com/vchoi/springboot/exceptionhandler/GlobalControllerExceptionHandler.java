package com.vchoi.springboot.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST;

@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleCustomExceptions(EntityNotFoundException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(exception.getMessage());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        log.error(this.getClass().getSimpleName(), ex);
        HttpStatus status;
        HttpHeaders headers = new HttpHeaders();
        if (ex instanceof MethodArgumentNotValidException || ex instanceof HttpMessageNotReadableException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
            status = HttpStatus.METHOD_NOT_ALLOWED;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return handleExceptionInternal(ex, headers, status, request);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleException(ApplicationException ex, WebRequest request) {
        ApiError apiError = ex.getApiError();
        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.valueOf(ex.getApiError().getStatus()));
    }

    private ResponseEntity<ApiError> handleExceptionInternal(Exception ex, HttpHeaders headers, HttpStatus status,
                                                             WebRequest request) {
        List<ApiErrorDetail> errors = null;
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, SCOPE_REQUEST);
        }

        if (ex instanceof MethodArgumentNotValidException) {
            errors = new ArrayList<>();
            getFieldErrorForMethodArgumentNotValid((MethodArgumentNotValidException) ex, errors);

            List<ObjectError> globalErrors = ((MethodArgumentNotValidException) ex)
                    .getBindingResult()
                    .getGlobalErrors();
            for (ObjectError error : globalErrors) {
                errors.add(new ApiErrorDetail(error.getObjectName(), null,
                        null, error.getDefaultMessage()));
            }

        } else if (ex instanceof HttpMessageNotReadableException) {
            errors = new ArrayList<>();
            HttpMessageNotReadableException detailException = ((HttpMessageNotReadableException) ex);
            System.out.println(ex.getMessage());
            errors.add(ApiErrorDetail.builder()
                    .message(Arrays.stream(ex.getMessage().split(":"))
                            .findFirst().orElse(((HttpMessageNotReadableException) ex)
                                    .getMostSpecificCause().getMessage()) + ", please check the input data")
                    .build());
        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
            errors = new ArrayList<>();
            HttpRequestMethodNotSupportedException detailException = ((HttpRequestMethodNotSupportedException) ex);
            errors.add(ApiErrorDetail.builder()
                    .message(detailException.getMessage())
                    .build());
        } else if (ex instanceof HttpClientErrorException.MethodNotAllowed) {
            errors = new ArrayList<>();
            HttpClientErrorException
                    .MethodNotAllowed detailException = ((HttpClientErrorException.MethodNotAllowed) ex);
            errors.add(
                    ApiErrorDetail.builder()
                            .message(detailException.getStatusCode().getReasonPhrase())
                            .build()
            );
        } else {
            errors = new ArrayList<>();
            errors.add(
                    ApiErrorDetail.builder()
                            .message(status.getReasonPhrase())
                            .build()
            );
        }

        ApiError apiError = ApiError.builder()
                .status(status.value())
                .statusMessage(status.getReasonPhrase())
                .timestamp(new Date())
                .errors(errors)
                .build();

        return new ResponseEntity<>(apiError, headers, status);
    }

    public static boolean isWrapperClassOrStringClass(Class<?> clazz) {
        return (ClassUtils.isPrimitiveOrWrapper(clazz)
                ||
                String.class == clazz);
    }

    private void getFieldErrorForMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                        List<ApiErrorDetail> errors) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            if (error.getRejectedValue() == null || !isWrapperClassOrStringClass(error.getRejectedValue().getClass())) {
                errors.add(ApiErrorDetail.builder()
                        .dataName(error.getObjectName())
                        .fieldName(error.getField())
                        .message(error.getDefaultMessage())
                        .build()
                );

            } else {
                errors.add(new ApiErrorDetail(error.getObjectName(), error.getField(),
                        String.valueOf(error.getRejectedValue()), error.getDefaultMessage()));
            }
        }
    }

}
