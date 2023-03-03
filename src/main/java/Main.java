import db.Storage;
import java.io.IOException;
import java.util.List;
import model.FruitTransaction;
import service.FileService;
import service.ReportService;
import service.TransactionExecutor;
import service.TransactionParser;
import service.impl.FileServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionExecutorImpl;
import service.impl.TransactionParserImpl;

public class Main {
    private static final String inputCsvFilePath = "src/main/resources/fruitTransactions.txt";
    private static final String outputCsvFilePath = "src/main/resources/fruitReport.txt";

    public static void main(String[] args) throws IOException {
        //read from file
        FileService fileService = new FileServiceImpl();
        List<String> inputTransactionString = fileService.readFromFile(inputCsvFilePath);
        //parse the input + fill in the storage
        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> transactionList = parser.parseTransaction(inputTransactionString);
        //fill the storage with Fruits
        Storage storage = new Storage();
        //execute transactions
        TransactionExecutor transactionExecutor = new TransactionExecutorImpl(storage);
        transactionExecutor.execute(transactionList);
        ReportService reporter = new ReportServiceImpl(storage);
        String report = reporter.createReport();
        fileService.writeToFile(outputCsvFilePath, report);
    }
}
