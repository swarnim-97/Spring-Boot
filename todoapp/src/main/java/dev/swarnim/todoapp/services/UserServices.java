package dev.swarnim.todoapp.services;

import dev.swarnim.todoapp.data.Data;
import dev.swarnim.todoapp.dto.userDto;
import dev.swarnim.todoapp.models.User;
import dev.swarnim.todoapp.repository.UserRepositoryInMemoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServices {

    private UserRepositoryInMemoryImpl userRepositoryInMemory;

    @Autowired
    UserServices(UserRepositoryInMemoryImpl userRepositoryInMemory){
        this.userRepositoryInMemory = userRepositoryInMemory;
    }

    public User createUser(User user){
        return userRepositoryInMemory.createUser(user);
    }

    public Data getUser(UUID id) {
        Data data = userRepositoryInMemory.getUser(id);
        return data;
    }

    public User deleteUser(UUID id){
        User user = userRepositoryInMemory.deleteUser(id);
        return user;
    }

    public Data updateUser(UUID id, User user){
        return userRepositoryInMemory.updateUser(id, user);
    }
}
