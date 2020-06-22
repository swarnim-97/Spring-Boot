package dev.swarnim.todoapp.services;

import dev.swarnim.todoapp.models.Note;
import dev.swarnim.todoapp.repository.NoteRepositoryInMemoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NoteServices {

    private NoteRepositoryInMemoryImpl noteRepositoryInMemoryImpl;

    @Autowired
    NoteServices(NoteRepositoryInMemoryImpl noteRepositoryInMemoryImpl){
        this.noteRepositoryInMemoryImpl = noteRepositoryInMemoryImpl;
    }

    public Note createNote(UUID id, Note note) {
        return noteRepositoryInMemoryImpl.createNote(id,note);
    }
}
