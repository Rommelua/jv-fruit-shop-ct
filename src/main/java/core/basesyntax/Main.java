package core.basesyntax;

import core.db.StorageDao;
import core.model.FruitTransaction;
import core.service.ReportService;
import core.service.TransactionParser;
import core.service.impl.FileServiceImpl;
import core.service.impl.TransactionExecutorImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/fruits.csv";
    private static final String PATH_TO_SAVE_REPORT = "src/main/resources/report.txt";

    public static void main(String[] args) {
        /*
         *              read data from csv file
         * @param PATH_TO_INPUT_FILE - origin file with data to process.
         */
        FileServiceImpl fileService = new FileServiceImpl();
        List<String> dataFromFile = fileService.readFile(PATH_TO_INPUT_FILE);

        /*
         *              process these data
         *
         */
        TransactionParser transactionParser = new TransactionParser();
        List<FruitTransaction> transactions = transactionParser.parser(dataFromFile);

        TransactionExecutorImpl transactionExecutor = new TransactionExecutorImpl();
        StorageDao storageData = transactionExecutor.executeTransactions(transactions);

        /*
         *              generate a report based on processed data
         *
         */
        ReportService reportService = new ReportService();
        String report = reportService.makeAReport(storageData);

        /*
         *              write report to new csv file
         *
         * @param PATH_TO_SAVE_REPORT - save data to file on computer,
         * @param report - processed data from csv file.
         */
        fileService.writeFile(PATH_TO_SAVE_REPORT, report);

    }
}
