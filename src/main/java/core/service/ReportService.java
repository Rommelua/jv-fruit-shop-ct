package core.service;

import core.db.StorageDao;
import java.util.Map;

public class ReportService {
    private final StorageDao storageDao;

    public ReportService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public String makeReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> storageEntry : storageDao.getAllFruits().entrySet()) {
            String fruit = storageEntry.getKey();
            String quantity = Integer.toString(storageEntry.getValue());
            report.append(System.lineSeparator()).append(fruit).append(",").append(quantity);
        }
        return report.toString();
    }
}
