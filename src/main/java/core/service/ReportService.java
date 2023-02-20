package core.service;

import core.db.StorageDao;
import java.util.Map;

public class ReportService {
    public String makeAReport(StorageDao storage) {
        String report = "";
        for (Map.Entry<String, Integer> data : storage.getMapOfFruits().entrySet()) {
            String fruit = data.getKey();
            String quantity = Integer.toString(data.getValue());
            report = report + fruit + "," + quantity + "\n";
        }

        return "fruit,quantity" + "\n" + report;
    }
}
