package dev.swarnim.todoapp.repository;

import dev.swarnim.todoapp.data.Data;
import dev.swarnim.todoapp.models.Note;
import dev.swarnim.todoapp.models.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
@Getter
@Setter
public class UserRepositoryInMemoryImpl implements UserRepository{

    private SessionFactory sessionFactory;
    private Data data;
    @Autowired
    UserRepositoryInMemoryImpl(SessionFactory sessionFactory, Data data){
        this.sessionFactory = sessionFactory;
        this.data = data;
    }

    @Override
    public User createUser(User user) {
        User createdUser = new User(user.getName(),user.getGender());
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(createdUser);
        session.getTransaction().commit();
        return createdUser;
    }

    @Override
    public Data getUser(UUID id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        Optional<User> users = Optional.ofNullable(user);
        if(users.isEmpty() || users.get().isDeleted()==true)
            return null;
        data.setGender(user.getGender());
        data.setName(user.getName());
        data.setUuid(user.getUser_id());
        for(UUID noteId: user.getNoteId()){
            Note note = session.get(Note.class, noteId);
            data.getMap().put(noteId, note.getNote());
        }
        return data;
    }

    @Override
    public User deleteUser(UUID id) {
        Session session  = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        user.setDeleted(true);
        for(UUID noteId: user.getNoteId()){
            Note note = session.get(Note.class, noteId);
            note.setDeleted(true);
        }
        session.getTransaction().commit();
        return user;
    }

    @Override
    public Data updateUser(UUID id, User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        User userData = session.get(User.class, id);
        if(userData==null || userData.isDeleted()==true)
            return null;
        userData.setGender(user.getGender());
        userData.setName(user.getName());
        session.getTransaction().commit();
        data.setGender(user.getGender());
        data.setName(user.getName());
        data.setUuid(userData.getUser_id());
        for(UUID noteId: userData.getNoteId()){
            Note note = session.get(Note.class, noteId);
            data.getMap().put(noteId, note.getNote());
        }
        return data;
    }


}
