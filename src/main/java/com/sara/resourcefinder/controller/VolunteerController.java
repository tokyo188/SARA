package com.sara.resourcefinder.controller;

import com.sara.resourcefinder.model.Volunteer;
import com.sara.resourcefinder.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @GetMapping
    public String listVolunteers(Model model) {
        List<Volunteer> volunteers = volunteerService.getAllVolunteers();
        model.addAttribute("volunteers", volunteers);
        return "volunteers/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("volunteer", new Volunteer());
        return "volunteers/form";
    }

    @PostMapping("/save")
    public String saveVolunteer(@ModelAttribute Volunteer volunteer) {
        volunteerService.saveVolunteer(volunteer);
        return "redirect:/volunteers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Volunteer volunteer = volunteerService.getVolunteerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid volunteer Id:" + id));
        model.addAttribute("volunteer", volunteer);
        return "volunteers/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteVolunteer(@PathVariable Long id) {
        volunteerService.deleteVolunteer(id);
        return "redirect:/volunteers";
    }
}
