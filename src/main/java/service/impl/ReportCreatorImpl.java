package service.impl;

import db.Storage;
import service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport(Storage storage) {
        String report = HEADER + System.lineSeparator();
        for (String string : storage.getAllFruits()) {
            report = report.concat(string);
        }
        return report;
    }
}
