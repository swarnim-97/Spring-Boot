package dev.swarnim.todoapp.repository;

import dev.swarnim.todoapp.data.Data;
import dev.swarnim.todoapp.models.Note;
import dev.swarnim.todoapp.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class NoteRepositoryInMemoryImpl implements NoteRepository{

    private SessionFactory sessionFactory;

    @Autowired
    public NoteRepositoryInMemoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Note createNote(UUID id, Note note) {
        Note createNote = new Note(note.getNote());
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.beginTransaction();
        session.save(createNote);
        user.getNoteId().add(createNote.getNoteUuid());
        session.save(user);
        session.getTransaction().commit();
        return createNote;
    }
}
