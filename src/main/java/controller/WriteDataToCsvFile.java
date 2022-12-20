package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Fruit;

public class WriteDataToCsvFile implements OutputData {
    private String headerToCsv = "fruit,quantity";

    @Override
    public void writeDataToFile(String filePath, List<Fruit> fruitList) {
        try (BufferedWriter outToCSV = new BufferedWriter(new FileWriter(filePath))) {
            outToCSV.write(headerToCsv + System.lineSeparator());
            for (Fruit fruit : fruitList) {
                outToCSV.write(fruit.getName() + ", " + String.valueOf(fruit.getAmount()) + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + filePath, e);
        }
    }
}
