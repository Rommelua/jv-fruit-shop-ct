package core.service;

import java.nio.file.Path;
import java.util.List;

public interface FileService {
    List<String> readFile(String pathToFile);

    Path writeFile(String pathToFile, String dataReport);
}
