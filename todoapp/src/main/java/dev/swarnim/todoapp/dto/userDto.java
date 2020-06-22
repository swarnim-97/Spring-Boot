package dev.swarnim.todoapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class userDto<T>{
    private HttpStatus statusCode;

    private T data;

    public userDto(HttpStatus statusCode, T data){
        this.statusCode = statusCode;
        this.data=data;
    }

    @Override
    public String toString(){
        return statusCode+" "+data;
    }
}
