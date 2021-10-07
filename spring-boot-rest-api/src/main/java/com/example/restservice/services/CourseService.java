package com.example.restservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Service
public class CourseService {

    private static final String COMMA_DELIMITER = ",";
    private static final String FilePath = "C:\\Users\\tomal\\final evaluation\\Final-Evaluation-Batch-3\\spring-boot-rest-api\\src\\main\\java\\com\\example\\restservice\\models\\tutorial\\Course.csv";

    @Autowired
    private ResultService resultService;

    public List<List<String>> addCourse() {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FilePath));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }


    public List<String> getCourse(int id) {
        List<List<String>> records = new ArrayList<>();
        records = addCourse();
        List<List<String>> resposeRecord;

        for (List<String> record : records) {
            if (Objects.equals(record.get(0), Integer.toString(id))) {
                return record;
            }
        }
        return (List<String>) null;
    }




}