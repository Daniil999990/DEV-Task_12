package com.example.DEVTask_12.controller;

import com.example.DEVTask_12.model.Note;
import com.example.DEVTask_12.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.findAll());
        return "list";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam("id") Long id, Model model) {
        model.addAttribute("note", noteService.getById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String saveNote(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}