package dev.swarnim.interviewbitclone.services;

import dev.swarnim.interviewbitclone.models.User;
import dev.swarnim.interviewbitclone.repository.UserRepository;
import dev.swarnim.interviewbitclone.repository.UserRepositoryInMemoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServices {

    private UserRepositoryInMemoryImpl userRepositoryInMemoryImpl;

    @Autowired
    UserServices(UserRepositoryInMemoryImpl userRepositoryInMemoryImpl){
        this.userRepositoryInMemoryImpl = userRepositoryInMemoryImpl;
    }

    public User createUser(User user){
        return userRepositoryInMemoryImpl.createUser(user);
    }

    public User getUser(UUID id) {
        Optional<User> foundUser = userRepositoryInMemoryImpl.getUser(id);
        if(foundUser.isEmpty())
            return null;
        else if(foundUser.isPresent() && foundUser.get().isDelete()==false)
            return foundUser.get();
        return null;
    }

    public User deleteUser(UUID id) {
        Optional<User> foundUser = userRepositoryInMemoryImpl.deleteUser(id);
        if(foundUser.isEmpty())
            return null;
        return foundUser.get();
    }

    public User updateUser(UUID id, User user) {
        Optional<User> deletedUser = userRepositoryInMemoryImpl.updateUser(id,user);
        if(deletedUser.isPresent()){
            return deletedUser.get();
        }
        return null;
    }

}
