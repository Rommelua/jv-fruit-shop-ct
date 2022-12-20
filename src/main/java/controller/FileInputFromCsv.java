package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputFromCsv implements InputData {

    @Override
    public List<String> getData(String fromFile) {

        List<String> inputData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file " + fromFile, e);
        }
        return inputData;
    }
}

