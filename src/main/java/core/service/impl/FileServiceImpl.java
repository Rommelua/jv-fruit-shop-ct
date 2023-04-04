package core.service.impl;

import core.service.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFile(String pathToFile) {
        Path path = Paths.get(pathToFile);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + pathToFile, e);
        }
    }

    @Override
    public Path writeFile(String pathToFile, String dataReport) {
        Path path = Paths.get(pathToFile);
        try {
            return Files.writeString(path, dataReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file, " + pathToFile, e);
        }
    }
}
