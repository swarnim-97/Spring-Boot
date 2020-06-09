package dev.swarnim.interviewbitclone.repository;

import dev.swarnim.interviewbitclone.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryInMemoryImpl implements UserRepository{

    private List<User> userDatabase = new ArrayList<>();

    @Override
    public User createUser(User user) {
        User createdUser = new User(user.getName(), user.getGender());
        userDatabase.add(createdUser);
        return createdUser;
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return userDatabase
                .stream()
                .filter(
                        user -> user.getUuid().equals(id)
                ).findFirst();
    }

    @Override
    public Optional<User> deleteUser(UUID id) {
        Optional<User> deletedUser = userDatabase
                .stream()
                .filter(
                        user -> user.getUuid().equals(id)
                ).findFirst();


        if (deletedUser.isPresent() && deletedUser.get().isDelete()==false) {

            User temp = deletedUser.get();
            userDatabase.remove(temp);
            User updatedValueOfDeletedUser = temp;
            updatedValueOfDeletedUser.setDelete(true);
            userDatabase.add(updatedValueOfDeletedUser);

        }
        else if(deletedUser.isPresent() && deletedUser.get().isDelete()==true)
            return Optional.empty();
        return deletedUser;
    }

    @Override
    public Optional<User> updateUser(UUID id, User user) {
        Optional<User> foundUser = userDatabase
                .stream()
                .filter(
                        users -> users.getUuid().equals(id)
                ).findFirst();
        if(foundUser.isPresent() && foundUser.get().isDelete()==false){
            User availableUser = foundUser.get();
            User updatedUser = new User(user.getName(),user.getGender());
            updatedUser.setUuid(id);
            int idx = userDatabase.indexOf(availableUser);
            userDatabase.set(idx,updatedUser);
            return Optional.of(updatedUser);
        }
        return Optional.empty();
    }
}
