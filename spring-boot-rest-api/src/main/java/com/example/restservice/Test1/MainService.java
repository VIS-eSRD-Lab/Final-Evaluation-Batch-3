package com.example.restservice.Test1;

import com.example.restservice.OnStartUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MainService {


    private OnStartUp onStartUp=new OnStartUp();

    List<Student> students=onStartUp.getStudents();
    List<Course> courses=onStartUp.getCourses();


    public List<Student> allStudents(){
        return students;
    }

    public Student findStudentById(int id){
        for(Student s: students){
            if(s.getId()==id){
                return s;
            }
        }
        return new Student();
    }

}
