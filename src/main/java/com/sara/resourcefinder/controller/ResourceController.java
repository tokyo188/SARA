package com.sara.resourcefinder.controller;

import com.sara.resourcefinder.model.Resource;
import com.sara.resourcefinder.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public String listResources(Model model) {
        List<Resource> resources = resourceService.getAllResources();
        model.addAttribute("resources", resources);
        return "resources/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("resource", new Resource());
        return "resources/form";
    }

    @PostMapping("/save")
    public String saveResource(@ModelAttribute Resource resource) {
        resourceService.saveResource(resource);
        return "redirect:/resources";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Resource resource = resourceService.getResourceById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid resource Id:" + id));
        model.addAttribute("resource", resource);
        return "resources/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return "redirect:/resources";
    }
}
