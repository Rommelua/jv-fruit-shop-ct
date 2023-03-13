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
    private static final String INPUT_FILE_PATH = "src/main/resources/fruitTransactions.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/fruitReport.txt";

    public static void main(String[] args) throws IOException {
        //read from file
        FileService fileService = new FileServiceImpl();
        List<String> inputStringsList = fileService.readFromFile(INPUT_FILE_PATH);
        //parse the input + fill in the storage
        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> transactionList = parser.parseTransactions(inputStringsList);
        //fill the storage with Fruits
        Storage storage = new Storage();
        //execute transactions
        TransactionExecutor transactionExecutor = new TransactionExecutorImpl(storage);
        transactionExecutor.execute(transactionList);
        ReportService reporter = new ReportServiceImpl(storage);
        String report = reporter.createReport();
        fileService.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
