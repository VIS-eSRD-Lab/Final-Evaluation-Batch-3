package com.example.restservice.controllers;

import java.util.List;

import com.example.restservice.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.models.Tutorial;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    private TutorialService service;

    @PostMapping("/add-tutorial")
    public Tutorial addList(@RequestBody Tutorial tutorials) {
        return service.createTutorialList(tutorials);
    }

    //Get by id
    @GetMapping("/get-tutorial/{id}")
    public Tutorial findById(@PathVariable long id) {
        return service.getById(id);
    }

    //Get All
    @GetMapping("/get-all-tutorial")
    public List<Tutorial> find() {
        return service.getAll();
    }

    //Update
    @PutMapping("/update-tutorial/{id}")
    public Tutorial update(@RequestBody Tutorial tutorial, @PathVariable("id") long id) {
        return service.updateTutorial(tutorial,id);
    }

    //Delete by id
    @DeleteMapping("/delete-tutorial/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }


}