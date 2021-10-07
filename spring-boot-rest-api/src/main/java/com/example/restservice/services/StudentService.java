package com.example.restservice.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Service
public class StudentService {
    private static final String COMMA_DELIMITER = ",";
    private static final String FilePath = "C:\\Projects\\hackathon\\Final-Evaluation-Batch-3\\spring-boot-rest-api\\src\\main\\java\\com\\example\\restservice\\csv\\student.csv";

    public List<List<String>> csvStudent(){
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

    public List<String> getStudent(int id){
        List<List<String>> records = new ArrayList<>();
        records = csvStudent();
        List<List<String>> resposeRecord;

        for(List<String> record: records){
            if(Objects.equals(record.get(0), Integer.toString(id))){
                return record;
            }
        }
        return (List<String>) null;
    }
}
