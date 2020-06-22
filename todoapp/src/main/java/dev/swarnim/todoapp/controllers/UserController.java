package dev.swarnim.todoapp.controllers;

import dev.swarnim.todoapp.data.Data;
import dev.swarnim.todoapp.dto.userDto;
import dev.swarnim.todoapp.models.User;
import dev.swarnim.todoapp.services.UserServices;
import dev.swarnim.todoapp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Constants.USER_END_POINTS)
public class UserController {

    private UserServices userServices;

    @Autowired
    UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userServices.createUser(user);
    }

    @GetMapping(value = "/{id}")
    public userDto getUser(@PathVariable UUID id){
        Data data = userServices.getUser(id);
        if(data!=null){
            userDto sendData = new userDto(HttpStatus.FOUND,data);
            return  sendData;
        }
        return new userDto(HttpStatus.NOT_FOUND,null);
    }

    @DeleteMapping(value = "/{id}")
    public User deleteUser(@PathVariable UUID id){
        return userServices.deleteUser(id);
    }

    @PutMapping(value = "/{id}")
    public userDto updateUser(@PathVariable UUID id, @RequestBody User user){
        Data data =  userServices.updateUser(id, user);
        if(data!=null)
            return new userDto(HttpStatus.OK, data);
        return new userDto(HttpStatus.NOT_FOUND, null);
    }
}
