package service;

import java.io.IOException;
import java.util.List;

public interface FileService {
    List<String> readFromFile(String filePath) throws IOException;

    void writeToFile(String filePath, String report) throws IOException;
}
