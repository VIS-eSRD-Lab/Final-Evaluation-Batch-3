package com.example.restservice.models.tutorial;

import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Id", "StudentID", "CourseID", "courseName", "courseFee", "phase", "session", "regStatus", "paymentStatus", "dueDate", "requestDate"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("src/main/resources/Data.csv")) {
            return true;
        }

        return false;
    }

    public static List<Registration> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Registration> developerTutorialList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Registration developerTutorial = new Registration(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("StudentID"),
                        csvRecord.get("CourseID"),
                        csvRecord.get("courseName"),
                        csvRecord.get("courseFee"),
                        csvRecord.get("phase"),
                        csvRecord.get("session"),
                        Boolean.parseBoolean(csvRecord.get("regStatus")),
                        Boolean.parseBoolean(csvRecord.get("paymentStatus")),
                        csvRecord.get("dueDate"),
                        csvRecord.get("requestDate")

                );

                developerTutorialList.add(developerTutorial);
            }

            return developerTutorialList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream tutorialsToCSV(List<Registration> developerTutorialList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Registration developerTutorial : developerTutorialList) {
                List<String> data = Arrays.asList(
                        String.valueOf(developerTutorial.getId())

                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}