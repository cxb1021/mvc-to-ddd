package org.lv.model.result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result<T> {
    private T data;
    private String error;
    
    public static Result error(String message) {
        return new Result(null, message);
    } 
}
