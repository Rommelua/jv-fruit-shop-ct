package core.service;

import core.db.StorageDao;
import java.util.Map;

public class ReportService {
    private final StorageDao storageDao;

    public ReportService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public String makeReport() {
        String report = "fruit,quantity";
        for (Map.Entry<String, Integer> storageEntry : storageDao.getAllFruits().entrySet()) {
            String fruit = storageEntry.getKey();
            String quantity = Integer.toString(storageEntry.getValue());
            report = report + System.lineSeparator() + fruit + "," + quantity;
        }
        return report;
    }
}
