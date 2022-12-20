package controller;

import java.util.List;
import model.Fruit;

/*
 * Implementation of this Interface allows write data
*/

public interface OutputData {
    void writeDataToFile(String filePath, List<Fruit> fruitList);
}
