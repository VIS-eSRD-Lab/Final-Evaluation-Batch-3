package com.example.restservice.Test2;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MyService {
    @Autowired
    CourseRepo courseRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    PhaseRepo phaseRepo;


    //Phase Work
    public void addPhase(Phase p){
        phaseRepo.save(p);
    }

    public void addPhases(List<Phase> phases){
        phaseRepo.saveAll(phases);
    }

    public List<Phase>  allPhases(){
        return phaseRepo.findAll();
    }

    //Course Work
    public void addCourse(Course c){
        courseRepo.save(c);
    }

    public void addCourses(List<Course> courses){
        courseRepo.saveAll(courses);
    }

    public List<Course>  allCourses(){
        return courseRepo.findAll();
    }

    //Student Work
    public void addStudent(Student s){
        studentRepo.save(s);
    }

    public void addStudents(List<Student> students){
        studentRepo.saveAll(students);
    }

    public List<Student>  allStudents(){
        return studentRepo.findAll();
    }

    public Map<Integer, List<Student>> allStudentsGrouping(){
        return studentRepo.findAll()
                .stream()
                .collect(Collectors.groupingBy(Student::getStd_id));
    }

    public Student getStudentbyId(int id){
        List<Student> students= studentRepo.findAll();
        Student s=new Student();
        for(Student ss: students){
            if(ss.getStd_id()==id){
                s=ss;
                break;
            }
        }

        List<Course> courses=s.getCourses();
        int sum=0;
        for(Course c: courses){
            sum+=c.getCourse_fee();
        }
        s.setPayableFee(sum);

        return s;
    }

    public void deleteStudentbyId(int id){
        List<Student> students= studentRepo.findAll();
        Student s=new Student();
        for(Student ss: students){
            if(ss.getStd_id()==id){
                s=ss;
                break;
            }
        }

        studentRepo.deleteById(s.getId());

    }

}
