package model;

import db.Storage;
import java.io.IOException;
import java.util.List;
import service.FileService;
import service.ReportCreator;
import service.StorageService;
import service.TransactionExecutor;
import service.TransactionParser;
import service.impl.FileServiceImpl;
import service.impl.ReportCreatorImpl;
import service.impl.StorageServiceImpl;
import service.impl.TransactionExecutorImpl;
import service.impl.TransactionParserImpl;

public class Main {
    private static final String inputCsvFilePath = "src/main/resources/fruitTransactions.txt";
    private static final String outputCsvFilePath = "src/main/resources/fruitReport.txt";

    public static void main(String[] args) throws IOException {
        //read from file
        FileService fileService = new FileServiceImpl();
        String inputTransactionString = fileService.readFromFile(inputCsvFilePath);
        //parse the input + fill in the storage
        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> transactionList = parser.parseTransaction(inputTransactionString);
        //fill the storage with Fruits
        StorageService storageService = new StorageServiceImpl();
        Storage storage = new Storage();
        // StorageDAO<Storage> storageDAO = new StorageDAOImpl(storage);
        //execute transactions
        TransactionExecutor transactionExecutor = new TransactionExecutorImpl(storage);
        storage = transactionExecutor.execute(transactionList);
        ReportCreator reporter = new ReportCreatorImpl();
        String report = reporter.createReport(storage);
        fileService.writeToFile(outputCsvFilePath,report);
    }
}
