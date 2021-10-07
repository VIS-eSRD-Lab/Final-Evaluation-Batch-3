package com.example.restservice.services;

import com.example.restservice.models.CourseRegistration;
import com.example.restservice.repository.CourseRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CourseRegistrationService {

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ResultService resultService;

    public CourseRegistration createCourseRegistration(CourseRegistration courseRegistration) {
        List<String> course = new ArrayList<>();
        List<String> student = new ArrayList<>();
        student = studentService.getStudent(courseRegistration.getStudentId());
        course = courseService.getCourse(courseRegistration.getCourseId());
        courseRegistration.setCourseName(course.get(1));
        courseRegistration.setCourseFee(Float.parseFloat(course.get(3)));
        courseRegistration.setPhase(Integer.parseInt(course.get(2)));

        /*List<List<String>> filterStdR = new ArrayList<>();
        filterStdR = resultService.filterResultS(courseRegistration.getStudentId());
        for(List<String> result: filterStdR){
            courseRegistration.setRegStatus(Objects.equals(Integer.parseInt(result.get(1)), courseRegistration.getCourseId()));
        }*/
        courseRegistration.setCreatedOn(Instant.now());

        return courseRegistrationRepository.save(courseRegistration);
    }

    public List<CourseRegistration> getAllCR(){
        return courseRegistrationRepository.findAll();
    }

    public CourseRegistration getCRById(int id){
        return courseRegistrationRepository.findById(id).orElse(null);
    }
}
