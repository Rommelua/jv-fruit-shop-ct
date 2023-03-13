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
        for (String str : input) {
            try {
                String[] transactionDetails = str.split(",");
                FruitTransaction fruitTransaction = new FruitTransaction(
                         FruitTransaction.Operation.fromCode(transactionDetails[0]),
                         new Fruit(transactionDetails[1]),
                         Integer.parseInt(transactionDetails[2]));
                fruitTransactionList.add(fruitTransaction);
            } catch (IllegalArgumentException exception) {
                throw new IllegalArgumentException("Illegal parameters for Transaction creation "
                        + exception.getMessage());
            }
        }
        return fruitTransactionList;
    }
}
