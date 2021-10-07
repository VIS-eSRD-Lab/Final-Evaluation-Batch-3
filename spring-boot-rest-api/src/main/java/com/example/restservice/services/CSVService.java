package com.example.restservice.services;

import com.example.restservice.models.tutorial.CSVHelper;
import com.example.restservice.models.tutorial.Registration;
import com.example.restservice.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    RegistrationRepository registrationRepository;

    public void save(MultipartFile file) {
        try {
            List<Registration> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            registrationRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Registration> getAllTutorials() {
        return registrationRepository.findAll();
    }
}
