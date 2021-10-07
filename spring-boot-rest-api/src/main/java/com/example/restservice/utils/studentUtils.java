package com.example.restservice.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class studentUtils {

    String line = "";
    String splitBy = ",";

    public void getAllStudent() {
        try {
            BufferedReader br = new BufferedReader((new FileReader("E:\\Final Evaluation\\Final-Evaluation-Batch-3\\CSV\\Student.csv")));
            while ((line = br.readLine()) != null) {
                String[] student = line.split(splitBy);
                System.out.println(student[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
