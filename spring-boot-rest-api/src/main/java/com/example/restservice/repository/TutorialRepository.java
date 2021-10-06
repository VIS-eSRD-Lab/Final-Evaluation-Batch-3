package com.example.restservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.models.tutorial.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}