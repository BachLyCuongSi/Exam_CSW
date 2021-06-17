package com.minhan.exam.model;

public class BaseResponse<T> {
    public int status = 0;
    public String message = "Error";
    public T data ;

}
