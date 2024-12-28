package com.spingjourney.Week2Homework.advices;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ApiResponse<T> {

    private LocalDateTime timeStamp;
    private T data;
    private ApiError apiError;

    public ApiResponse(){
        timeStamp=LocalDateTime.now();
    }
    public ApiResponse(T data){
        this();
        this.data=data;
    }
    public ApiResponse(ApiError apiError){
        this();
        this.apiError=apiError;
    }
}
