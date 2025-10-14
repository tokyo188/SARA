package com.sara.resourcefinder.controller;

import com.sara.resourcefinder.model.Donor;
import com.sara.resourcefinder.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/donors")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @GetMapping
    public String listDonors(Model model) {
        List<Donor> donors = donorService.getAllDonors();
        model.addAttribute("donors", donors);
        return "donors/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("donor", new Donor());
        return "donors/form";
    }

    @PostMapping("/save")
    public String saveDonor(@ModelAttribute Donor donor) {
        donorService.saveDonor(donor);
        return "redirect:/donors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Donor donor = donorService.getDonorById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid donor Id:" + id));
        model.addAttribute("donor", donor);
        return "donors/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return "redirect:/donors";
    }
}
