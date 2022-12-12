package model;

import controller.Balance;
import controller.FileInputFromCsv;
import controller.InputData;
import controller.OperationStrategy;
import controller.OutputData;
import controller.Purchase;
import controller.Return;
import controller.Supply;
import controller.WriteDataToCsvFile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * it`s a good idea to create several queues for each product in the Store and
 * execute operations for them in different threads
*/

public class Store {
    private List<Fruit> productList;
    private OperationStrategy strategy;
    private String csvFilePath = "C:\\Users\\Serhii Zaitsev\\IdeaProjects\\jv-fruit-shop-ct"
            + "\\src\\main\\java\\res\\fruitTransactions.txt";
    private String csvFilePathOut = "C:\\Users\\Serhii Zaitsev\\IdeaProjects\\jv-fruit-shop-ct"
            + "\\src\\main\\java\\res\\fruitTransactions_out.txt";

    public void startWorkingDay() {
        //get data from CSV file
        InputData inputData = new FileInputFromCsv();
        List<FruitTransaction> fruitTransactionList = new FruitTransaction()
                .fruitTransactionList(inputData.getData(csvFilePath));
        //fill the names to the product map
        productList = fillProductList(fruitTransactionList);
        //operations with transactionList
        runTransactionList(fruitTransactionList);
        //export to CSV file
        OutputData writerToFileCsv = new WriteDataToCsvFile();
        writerToFileCsv.writeDataToFile(csvFilePathOut, productList);
    }

    private void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    private Fruit executeStrategy(FruitTransaction transaction, Fruit fruit) {
        return strategy.executeOperation(transaction,fruit);
    }

    private List<Fruit> fillProductList(List<FruitTransaction> transactionList) {
        List<Fruit> fruitList = new ArrayList<>();
        Set<String> fruitFilterToFillIn = new HashSet();
        for (FruitTransaction transaction: transactionList) {
            fruitFilterToFillIn.add(transaction.getFruit());
        }
        for (String fruitName: fruitFilterToFillIn) {
            fruitList.add(new Fruit(fruitName));
        }
        return fruitList;
    }

    private void runTransactionList(List<FruitTransaction> transactionList) {
        for (int i = 0; i < transactionList.size(); i++) {
            if ("b".equals(transactionList.get(i).getOperation().getOperation())) {
                setStrategy(new Balance());
            }
            if ("p".equals(transactionList.get(i).getOperation().getOperation())) {
                setStrategy(new Purchase());
            }
            if ("r".equals(transactionList.get(i).getOperation().getOperation())) {
                setStrategy(new Return());
            }
            if ("s".equals(transactionList.get(i).getOperation().getOperation())) {
                setStrategy(new Supply());
            }
            int index = productList.indexOf(transactionList.get(i).getFruit());
            Fruit fruitToInsert = executeStrategy(transactionList.get(i),productList.get(
                    productList.indexOf(transactionList.get(i).getFruit())));
            productList.set(index,fruitToInsert);
        }
    }
}
