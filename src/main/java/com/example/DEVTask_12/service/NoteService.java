package com.example.DEVTask_12.service;

import com.example.DEVTask_12.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NoteService {

    private List<Note> notes = new ArrayList<>();

    public NoteService() {
        notes.add(new Note("Заголовок 1", "Контент 1"));
        notes.add(new Note("Заголовок 2", "Контент 2"));
    }

    public List<Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
        note.setId(new Random().nextLong());
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        notes.removeIf(note -> note.getId() == id);
    }

    public void update(Note note) {
        for (Note n : notes) {
            if (n.getId() == note.getId()) {
                n.setTitle(note.getTitle());
                n.setContent(note.getContent());
                break;
            }
        }
    }

    public Note getById(long id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }
}
