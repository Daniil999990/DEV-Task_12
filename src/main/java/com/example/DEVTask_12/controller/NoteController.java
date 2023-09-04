package com.example.DEVTask_12.controller;

import com.example.DEVTask_12.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/note")
public class NoteController {

    private List<Note> notes = new ArrayList<>();

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", notes);
        return "list";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam("id") Long id, Model model) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                model.addAttribute("note", note);
                break;
            }
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String saveNote(@ModelAttribute Note note) {
        for (Note existingNote : notes) {
            if (existingNote.getId().equals(note.getId())) {
                existingNote.setTitle(note.getTitle());
                existingNote.setContent(note.getContent());
                break;
            }
        }
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        notes.removeIf(note -> note.getId().equals(id));
        return "redirect:/note/list";
    }

    // Цей метод додає тестові нотатки для прикладу
    @GetMapping("/addTestData")
    public String addTestData() {
        notes.add(new Note("Заголовок 1", "Контент 1"));
        notes.add(new Note("Заголовок 2", "Контент 2"));
        return "redirect:/note/list";
    }
}
