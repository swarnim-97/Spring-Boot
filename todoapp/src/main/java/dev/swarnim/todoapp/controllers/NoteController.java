package dev.swarnim.todoapp.controllers;

import dev.swarnim.todoapp.models.Note;
import dev.swarnim.todoapp.services.NoteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dev.swarnim.todoapp.utils.Constants;

import java.util.UUID;

@RestController
@RequestMapping(Constants.USER_END_POINTS)
public class NoteController {

    private NoteServices noteServices;

    @Autowired
    NoteController(NoteServices noteServices){
        this.noteServices = noteServices;
    }

    @PostMapping(value = "/{id}")
    public Note createNote(@PathVariable UUID id, @RequestBody Note note){
        return noteServices.createNote(id,note);
    }

}
