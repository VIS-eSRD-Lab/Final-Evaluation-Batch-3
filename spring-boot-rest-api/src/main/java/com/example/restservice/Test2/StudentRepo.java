package com.example.restservice.Test2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  StudentRepo extends JpaRepository<Student, Integer> {
}
