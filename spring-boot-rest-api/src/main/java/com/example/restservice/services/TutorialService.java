package com.example.restservice.services;
import com.example.restservice.models.tutorial.Tutorial;
import com.example.restservice.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {
    @Autowired
    private TutorialRepository tutorialRepository;

    //create
    public Tutorial createTutorialList(Tutorial tutorials) {
        return tutorialRepository.save(tutorials);
    }

    //get by id
    public Tutorial getById(Long id) {
        Tutorial tutorial = tutorialRepository.findById(id).orElse(null);
        assert tutorial != null;
        return tutorial;
    }

    //Get All
    public List<Tutorial> getAll() {
        List<Tutorial> tutorials = tutorialRepository.findAll();

        return tutorials;
    }


    //Delete All
    public void deleteAll() {
        tutorialRepository.deleteAll();
    }

    public void deleteById(long id) {
        Tutorial tutorial = tutorialRepository.findById(id).orElse(null);

        assert tutorial != null;
        tutorialRepository.deleteById(id);

    }

    public Tutorial updateTutorial(Tutorial tutorial, long id) {

        Optional<Tutorial> data = tutorialRepository.findById(id);
        Tutorial newTutorial = data.get();

        assert newTutorial != null;
        newTutorial.setTitle(tutorial.getTitle());
        newTutorial.setDescription(tutorial.getDescription());
        tutorialRepository.save(newTutorial);
        return newTutorial;
    }


}
