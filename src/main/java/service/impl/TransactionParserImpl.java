package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.FruitTransaction;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private List<FruitTransaction> fruitTransactionList;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> input) {
        fruitTransactionList = new ArrayList<>();
        input.remove(0);
        for (String inputLine : input) {
            FruitTransaction fruitTransaction = parseLine(inputLine);
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }

    private FruitTransaction parseLine(String str) {
        String[] transactionDetails = str.split(",");
        return new FruitTransaction(
                 FruitTransaction.Operation.fromCode(transactionDetails[0]),
                 new Fruit(transactionDetails[1]),
                 Integer.parseInt(transactionDetails[2]));
    }
}
