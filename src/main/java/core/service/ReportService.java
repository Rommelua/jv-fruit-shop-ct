package core.service;

import core.db.StorageDao;
import java.util.Map;

public class ReportService {
    private final StorageDao storageDao;

    public ReportService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public String makeReport() {
        String report = "";
        for (Map.Entry<String, Integer> data : storageDao.getAllFruits().entrySet()) {
            String fruit = data.getKey();
            String quantity = Integer.toString(data.getValue());
            report = report + fruit + "," + quantity + "\n";
        }
        return "fruit,quantity" + "\n" + report;
    }
}
