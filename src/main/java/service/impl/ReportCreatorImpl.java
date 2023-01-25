package service.impl;

import db.Storage;
import model.Fruit;
import service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport(Storage storage) {
        String report = HEADER + System.lineSeparator();
        for (Fruit fruit : storage.getFruitsInStorage().keySet()) {
            report = report.concat(fruit.getName() + ","
                    + storage.getFruitAmount(fruit)) + System.lineSeparator();
        }
        return report;
    }
}
