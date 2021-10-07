package com.example.restservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class CourseService {

    private static final String COMMA_DELIMITER = ",";
    private static final String FilePath = "C:\\Projects\\hackathon\\Final-Evaluation-Batch-3\\spring-boot-rest-api\\src\\main\\java\\com\\example\\restservice\\csv\\course.csv";

    @Autowired
    private ResultService resultService;

    public List<List<String>> getCourseByPhase(int id) {
        List<List<String>> records = new ArrayList<>();
        records = csvCourse();
       return resultService.getResultByPhase(id, records);
    }

    public List<List<String>> getCourseByStudent(int id) {
        List<List<String>> records = new ArrayList<>();
        records = csvCourse();
        return resultService.getResultByStudent(id, records);
    }

    public List<String> getCourse(int id) {
        List<List<String>> records = new ArrayList<>();
        records = csvCourse();
        List<List<String>> resposeRecord;

        for (List<String> record : records) {
            if (Objects.equals(record.get(0), Integer.toString(id))) {
                return record;
            }
        }
        return (List<String>) null;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        System.out.println(values);
        return values;
    }

    public List<List<String>> csvCourse() {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FilePath));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(records);
        return records;
    }
}
