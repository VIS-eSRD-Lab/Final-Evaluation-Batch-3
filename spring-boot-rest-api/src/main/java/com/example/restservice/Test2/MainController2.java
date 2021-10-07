package com.example.restservice.Test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class MainController2 {
    @Autowired
    MyService myService;

    @PostMapping("/addPhase")
    public String addPhase(@RequestBody Phase phase){
        myService.addPhase(phase);
        return "Added 1 Phase";
    }

    @PostMapping("/addPhases")
    public String addPhases(@RequestBody List<Phase> phases){
        myService.addPhases(phases);
        return "Added All Phases";
    }

    @GetMapping("/phase/get-all")
    public List<Phase> getAllPhase(){
        return myService.allPhases();
    }


    //Course
    @PostMapping("/addCourse")
    public String addCourse(@RequestBody Course course){
        myService.addCourse(course);
        return "Added 1 course";
    }

    @PostMapping("/addCourses")
    public String addCourses(@RequestBody List<Course> courses){
        myService.addCourses(courses);
        return "Added All Courses";
    }

    @GetMapping("/course/get-all")
    public List<Course> getAllCourses(){
        return myService.allCourses();
    }



    //Student
    @PostMapping("/addStudent")
    public String addStd(@RequestBody Student student){
        myService.addStudent(student);
        return "Added 1 student";
    }

    @PostMapping("/addStudents")
    public String addStds(@RequestBody List<Student> student){
        myService.addStudents(student);
        return "Added All Students";
    }

    @GetMapping("/reg/get/all")
    public Map<Integer, List<Student>> allStudents(){
        return myService.allStudentsGrouping();
    }

    @GetMapping("/reg/get/{id}")
    public Student getStudent(@PathVariable("id") int id){
        return myService.getStudentbyId(id);
    }

    @GetMapping("/student/get-all")
    public List<Student> getAllStudent(){
        return myService.allStudents();
    }

    @DeleteMapping("/student/get/{id}")
    public void deleteStudentbyId(int id){
        myService.deleteStudentbyId(id);
    }

}
