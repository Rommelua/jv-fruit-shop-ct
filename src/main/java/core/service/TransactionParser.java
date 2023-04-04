package core.service;

import core.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;

    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> transactionsList = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] dividedLine = data.get(i).split(",");
            FruitTransaction fruitTransaction = getTransaction(dividedLine);
            transactionsList.add(fruitTransaction);
        }
        return transactionsList;
    }

    private FruitTransaction getTransaction(String[] dividedLine) {
        return new FruitTransaction(
                FruitTransaction.Operation.getByCode(dividedLine[OPERATION_INDEX]),
                dividedLine[FRUIT],
                Integer.parseInt(dividedLine[AMOUNT])
        );
    }
}
