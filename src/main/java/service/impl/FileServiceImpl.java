package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import service.FileService;

public class FileServiceImpl implements FileService {

    @Override
    public void writeToFile(String filePath, String report) {
        Path path = Path.of(filePath);
        try {
            Files.write(path, report.getBytes());
        } catch (IOException exception) {
            throw new RuntimeException("File with the path not found " + filePath);
        }
    }

    @Override
    public List<String> readFromFile(String filePath) {
        Path path = Path.of(filePath);
        List<String> inputLinesList = new ArrayList<>();
        try {
            inputLinesList = Files.readAllLines(path);
        } catch (IOException exception) {
            throw new RuntimeException("Can`t read the file with the path " + filePath);
        }
        return inputLinesList;
    }
}

