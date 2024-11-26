package com.codecomet.week2.employeeproject.SankalpProject.advices;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class ApiResponse<T>{

    private LocalDateTime timeStamp;
    private T date;
    private ApiError error;

    public ApiResponse() {
        this.timeStamp= LocalDateTime.now();
    }

    public ApiResponse(T date) {
        this();
        this.date = date;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
