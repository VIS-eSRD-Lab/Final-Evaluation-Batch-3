package com.example.restservice;

import com.example.restservice.Test1.Course;
import com.example.restservice.Test1.Result;
import com.example.restservice.Test1.Student;
import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RestController
public class OnStartUp {

    //API Start

    @GetMapping("student/get/all")
    public List<Student> allStudents(){
        return students;
    }

    @GetMapping("student/get/{id}")
    public Student findStudentById(@PathVariable("id") int id){
        for(Student s: students){
            if(s.getId()==id){
                return s;
            }
        }
        return new Student();
    }

    @GetMapping("course/get/all")
    public List<Course> allCourses(){
        return courses;
    }

    @GetMapping("course/get/{id}")
    public Course findCourseById(@PathVariable("id") int id){
        for(Course s: courses){
            if(s.getId()==id){
                return s;
            }
        }
        return new Course();
    }

    @GetMapping("course/byphase/get/{id}")
    public List<Course> findCoursesByPhaseId(@PathVariable("id") int id){
        List<Course> byPhase=new ArrayList<>();
        for(Course s: courses){
            if(s.getPhase()==id){
                byPhase.add(s);
            }
        }
        return byPhase;
    }

    @GetMapping("course/bystudent/get/{id}")
    public List<Course> findcoursegetid(@PathVariable("id") int id){
        for(Student s: students){
            if(s.getId()==id){
                return s.getCourses();
            }
        }
        return new ArrayList<>();
    }


    //API END

    List<Course> courses =new ArrayList<>();
    List<Student> students =new ArrayList<>();
    List<Result> results= new ArrayList<>();

    public OnStartUp() {
    }

    public OnStartUp(List<Course> courses, List<Student> students, List<Result> results, Student tempStudent) {
        this.courses = courses;
        this.students = students;
        this.results = results;
        this.tempStudent = tempStudent;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Result> getResults() {
        return results;
    }

    @EventListener
    public void ReadExcel(ApplicationStartedEvent event){


        try (InputStream inputStream = new FileInputStream(new File("E:/Projects/vInternship/Hackathon/Workspace/Final-Evaluation-Batch-3/Data.xlsx"))) {
            Workbook workbook = StreamingReader.builder().rowCacheSize(200).bufferSize(4096).open(inputStream);

            //Course Read
            Sheet sheet1= workbook.getSheet("Course");
            int k=0;
            for(Row row: sheet1){
                Course c=new Course();
                int j=0;
                for(Cell cell: row){
                    if(j==0){
                       c.setId((int)cell.getNumericCellValue());
                    }
                    else if(j==1){
                        c.setName(cell.getStringCellValue().trim());
                    }
                    else if(j==2){
                       c.setPhase((int)cell.getNumericCellValue());
                    }
                    else if(j==3){
                        c.setFee((int)cell.getNumericCellValue());
                    }
                    j++;
                }
                this.courses.add(c);
                k++;
            }

            //Student Read
            Sheet sheet2= workbook.getSheet("Student");
            k=0;
            for(Row row: sheet2){
                Student s=new Student();
                int j=0;
                for(Cell cell: row){
                    if(j==0){
                        s.setId((int)cell.getNumericCellValue());
                    }
                    else if(j==1){
                        s.setName(cell.getStringCellValue().trim());
                    }
                    else if(j==2){
                        s.setDob(cell.getStringCellValue().trim());
                    }
                    else if(j==3){
                        s.setPhone("0"+cell.getNumericCellValue());
                    }
                    else if(j==4){
                        s.setEmail(cell.getStringCellValue().trim());
                    }
                    else if(j==5){
                        s.setBatch(cell.getStringCellValue().trim());
                    }
                    else if(j==6){
                        s.setPrePhase((int)cell.getNumericCellValue());
                    }
                    else if(j==7){
                        s.setCurrentPhase((int)cell.getNumericCellValue());
                    }
                    j++;
                }
                this.students.add(s);
                k++;
            }

            //Result Read
            Sheet sheet3= workbook.getSheet("Result");
            k=0;
            for(Row row: sheet3){
                Result r=new Result();
                int j=0;
                for(Cell cell: row){
                    if(j==0){
                        r.setStdId((int)cell.getNumericCellValue());
                    }
                    else if(j==3){
                        r.setGrade(cell.getStringCellValue().trim());
                    }
                    else if(j==1){
                        r.setCourseId((int)cell.getNumericCellValue());
                    }
                    else if(j==2){
                        r.setPhase((int)cell.getNumericCellValue());
                    }
                    j++;
                }
                this.results.add(r);
                k++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        processData();

//        System.out.println(this.students.get(0).getCourses());
//        for(Course c: this.students.get(0).getCourses()){
//            System.out.println(c.getName());
//            System.out.println(c.getPhase());
//            System.out.println(c.getId());
//        }
    }

    Student tempStudent=new Student();

    void processData(){
        for(Result result: results){

            Student s=new Student();
            if(result.getStdId()==tempStudent.getId()){
                s=tempStudent;
            }else{
                for(Student ss: students){
                    if(ss.getId()==result.getStdId()){
                        s=ss;
                        tempStudent=ss;
                        break;
                    }
                }
            }

            if(result.getGrade().equals("Failed")){
                boolean isPassed=false;
                int courseId=result.getCourseId();

                for(Result r: results){
                        if(r.getCourseId()==courseId && r.getGrade().equals("Passed") && r.getStdId()==result.getStdId()) {
                            isPassed = true;
                            break;
                        }
                }

                if(!isPassed){
                    for(Course course: courses){
                        if(course.getId()==result.getCourseId()){
                            List<Course> cs= s.getCourses();
                            boolean isAdded=false;
                            for(Course c: cs){
                                if(c.getId()==courseId){
                                    isAdded=true;
                                    break;
                                }
                            }

                            if(!isAdded){
                                s.addCourse(course);
                            }
                            break;
                        }
                    }
                }


            }

        }
        preProcess();
    }

    public void preProcess(){
        for(Student s: students){
            int phaseNo= s.getCurrentPhase();
            for(Course c: courses){
                if(c.getPhase()==phaseNo){
                    s.addCourse(c);
                }
            }
        }
    }

}
