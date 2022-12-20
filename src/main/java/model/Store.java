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
    //update path to file. create a file for output
    private String csvFilePath = "src/main/java/res/fruitTransactions.txt";
    private String csvFilePathOut = "src/main/java/res/fruitTransactions_1.txt";

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

    private int executeStrategy(FruitTransaction transaction, Fruit fruit) {
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
            if (transactionList.get(i).getOperation() == FruitTransaction.Operation.BALANCE) {
                setStrategy(new Balance());
            }
            if (transactionList.get(i).getOperation() == FruitTransaction.Operation.PURCHASE) {
                setStrategy(new Purchase());
            }
            if (transactionList.get(i).getOperation() == FruitTransaction.Operation.RETURN) {
                setStrategy(new Return());
            }
            if (transactionList.get(i).getOperation() == FruitTransaction.Operation.SUPPLY) {
                setStrategy(new Supply());
            }
            int index = getProductIndex(transactionList.get(i).getFruit());
            int quantityOfFruit = executeStrategy(transactionList.get(i),productList.get(index));
            productList.get(index).setAmount(quantityOfFruit);
        }
    }

    private int getProductIndex(String prodName) {
        int index = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (prodName.equals(productList.get(i).getName())) {
                index = i;
                break;
            }
        }
        return index;
    }
}
