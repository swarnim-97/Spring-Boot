package dev.swarnim.todoapp.repository;

import dev.swarnim.todoapp.data.Data;
import dev.swarnim.todoapp.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    public User createUser(User user);
    public Data getUser(UUID id);
    public User deleteUser(UUID id);
    public Data updateUser(UUID id, User user);
}
