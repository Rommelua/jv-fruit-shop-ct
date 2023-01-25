package service;

import java.io.IOException;

public interface FileService {
    String readFromFile(String filePath) throws IOException;

    void writeToFile(String filePath, String report) throws IOException;
}
