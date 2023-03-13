package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import service.FileService;

public class FileServiceImpl implements FileService {

    @Override
    public void writeToFile(String filePath, String report) throws IOException {
        Path path = Path.of(filePath);
        try {
            byte[] reportBytes = report.getBytes();
            Path writeToFilePath = Files.write(path,reportBytes);
        } catch (IOException exception) {
            throw new IOException("File with the path not found" + exception.getMessage());
        }
    }

    @Override
    public List<String> readFromFile(String filePath) throws IOException {
        Path path = Path.of(filePath);
        List<String> inputLinesList = new ArrayList<>();
        try {
            inputLinesList = Files.readAllLines(path);
        } catch (IOException exception) {
            throw new IOException("Can`t read the file with the path" + filePath);
        }
        inputLinesList.remove(0);
        return inputLinesList;
    }
}

