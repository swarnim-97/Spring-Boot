package dev.swarnim.todoapp.repository;

import dev.swarnim.todoapp.models.Note;

import java.util.UUID;

public interface NoteRepository {
    public Note createNote(UUID id, Note note);
}
