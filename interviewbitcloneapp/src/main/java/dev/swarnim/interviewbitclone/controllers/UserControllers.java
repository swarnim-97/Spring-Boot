package dev.swarnim.interviewbitclone.controllers;

import dev.swarnim.interviewbitclone.dto.UserDto;
import dev.swarnim.interviewbitclone.models.User;
import dev.swarnim.interviewbitclone.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import dev.swarnim.interviewbitclone.utils.Constants;

import java.util.UUID;

@RestController
@RequestMapping(Constants.USERS_END_POINTS)
public class UserControllers {

    private UserServices userServices;

    @Autowired
    UserControllers(UserServices userServices){
        this.userServices = userServices;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userServices.createUser(user);
    }

    @GetMapping(value = "/{id}")
    public UserDto getUser(@PathVariable UUID id){
        User sendUser = userServices.getUser(id);
        if(sendUser!=null){
            return new UserDto(HttpStatus.FOUND, sendUser);
        }
        return new UserDto(HttpStatus.NOT_FOUND, null);
    }

    @DeleteMapping(value = "/{id}")
    public UserDto deleteUser(@PathVariable UUID id){
        User deletedUser = userServices.deleteUser(id);
        if(deletedUser!=null){
            return new UserDto(HttpStatus.OK, deletedUser);
        }
        return new UserDto(HttpStatus.NOT_FOUND, null);
    }

    @PutMapping(value = "/{id}")
    public UserDto updateUser(@PathVariable UUID id, @RequestBody User user){
        User updatedUser = userServices.updateUser(id,user);
        if(updatedUser!=null)
            return new UserDto(HttpStatus.OK,updatedUser);
        return new UserDto(HttpStatus.NO_CONTENT, null);
    }
}
