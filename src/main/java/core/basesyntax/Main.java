package core.basesyntax;

import core.db.StorageDao;
import core.model.FruitTransaction;
import core.service.ReportService;
import core.service.TransactionExecutor;
import core.service.TransactionParser;
import core.service.impl.FileServiceImpl;
import core.service.impl.TransactionExecutorImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/fruits.csv";
    private static final String PATH_TO_SAVE_REPORT = "src/main/resources/report.txt";

    public static void main(String[] args) {
        FileServiceImpl fileService = new FileServiceImpl();
        List<String> dataFromFile = fileService.readFile(PATH_TO_INPUT_FILE);

        TransactionParser transactionParser = new TransactionParser();
        List<FruitTransaction> transactions = transactionParser.parse(dataFromFile);

        StorageDao storage = new StorageDao();

        TransactionExecutor transactionExecutor = new TransactionExecutorImpl();
        transactionExecutor.executeTransactions(transactions, storage);

        ReportService reportService = new ReportService();
        String fruitBalance = reportService.makeReport(storage);
        fileService.writeFile(PATH_TO_SAVE_REPORT, fruitBalance);
    }
}
