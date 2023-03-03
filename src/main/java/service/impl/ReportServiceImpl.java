package service.impl;

import db.Storage;
import model.Fruit;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private Storage storage;

    public ReportServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String createReport() {
        String report = HEADER + System.lineSeparator();
        for (Fruit fruit : storage.getAllFruits().keySet()) {
            report = report.concat(fruit.getName() + ","
                    + storage.getFruitAmount(fruit)
                    + System.lineSeparator());
        }
        return report;
    }
}
