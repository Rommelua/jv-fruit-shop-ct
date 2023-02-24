package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransaction;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private List<FruitTransaction> fruitTransactionList;

    @Override
    public List<FruitTransaction> parseTransaction(String input) {
        fruitTransactionList = new ArrayList<>();
        String[] inputData = input.split(System.lineSeparator());
        for (int i = 1; i < inputData.length; i++) {
            String[] transactionDetails = inputData[i].split(",");
            FruitTransaction fruitTransaction = new FruitTransaction(
                     FruitTransaction.Operation.fromCode(transactionDetails[0]),
                    new Fruit(transactionDetails[1]),
                    Integer.parseInt(transactionDetails[2]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
