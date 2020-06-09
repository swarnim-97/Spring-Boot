package dev.swarnim.interviewbitclone.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserDto<T>{
    private HttpStatus statusCode;

    private T data;

    public UserDto(HttpStatus statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }
}
