package com.example.restservice.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class ResultService {
    private static final String COMMA_DELIMITER = ",";
    private static final String FilePath = "C:\\Projects\\hackathon\\Final-Evaluation-Batch-3\\spring-boot-rest-api\\src\\main\\java\\com\\example\\restservice\\csv\\result.csv";

    public List<List<String>> csvResult(){
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

    public List<List<String>> getResultByPhase(int id, List<List<String>> courses){
        List<List<String>> records = new ArrayList<>();
        records = csvResult();

        List<List<String>> filterRecords = new ArrayList<>();
        List<List<String>> respRecords = new ArrayList<>();

        for(List<String> record: records){
            if(Objects.equals(record.get(2), Integer.toString(id))){
                filterRecords.add(record);
            }
        }

        int mark[] = new int[1000];
        for(int i = 0; i < 1000; i++)mark[i] = 0;

        for (List<String> filterRecord: filterRecords){
           for(List<String> course: courses){
               if(Objects.equals(filterRecord.get(1), course.get(0))){
                   if(mark[Integer.parseInt(course.get(0))] == 0){
                       respRecords.add(course);
                       mark[Integer.parseInt(course.get(0))] = Integer.parseInt(course.get(0));
                   }
               }
           }
        }
        return respRecords;
    }

    public List<List<String>> getResultByStudent(int id, List<List<String>> courses){
        List<List<String>> records = new ArrayList<>();
        records = csvResult();

        List<List<String>> filterRecords = new ArrayList<>();
        List<List<String>> respRecords = new ArrayList<>();

        for(List<String> record: records){
            if(Objects.equals(record.get(0), Integer.toString(id))){
                filterRecords.add(record);
            }
        }
        System.out.println(filterRecords);

        int mark[] = new int[1000];
        for(int i = 0; i < 1000; i++)mark[i] = 0;

        for (List<String> filterRecord: filterRecords){
            for(List<String> course: courses){
                if(Objects.equals(filterRecord.get(1), course.get(0))){
                    if(mark[Integer.parseInt(course.get(0))] == 0){
                        respRecords.add(course);
                        mark[Integer.parseInt(course.get(0))] = Integer.parseInt(course.get(0));
                    }
                }
            }
        }
        return respRecords;
    }
}
