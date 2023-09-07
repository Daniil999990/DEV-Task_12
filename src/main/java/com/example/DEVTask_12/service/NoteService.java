package com.example.DEVTask_12.service;

import com.example.DEVTask_12.model.Note;
import com.example.DEVTask_12.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note getById(Long id) {
        return noteRepository.findById(id).orElseGet(() -> null);
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
