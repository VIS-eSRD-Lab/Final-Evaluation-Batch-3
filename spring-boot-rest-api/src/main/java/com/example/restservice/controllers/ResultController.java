package com.example.restservice.controllers;

import com.example.restservice.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/finalevaluation/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/get/all")
    public @ResponseBody ResponseEntity<List<List<String>>> getAllResult() {

        return new ResponseEntity<>(
                resultService.csvResult(),
                HttpStatus.OK
        );
    }
}
