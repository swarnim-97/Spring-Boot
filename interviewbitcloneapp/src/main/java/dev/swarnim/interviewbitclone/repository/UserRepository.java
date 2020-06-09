package dev.swarnim.interviewbitclone.repository;


import dev.swarnim.interviewbitclone.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    public User createUser(User user);

    public Optional<User> getUser(UUID id);

    public Optional<User> deleteUser(UUID id);

    public Optional<User> updateUser(UUID id, User user);
}
