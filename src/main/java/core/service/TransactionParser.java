package core.service;

import core.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParser {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;

    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> transactionsList = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] dividedLine = data.get(i).split(",");
            FruitTransaction fruitTransaction = new FruitTransaction(
                    FruitTransaction.Operation.getByCode(dividedLine[OPERATION]),
                    dividedLine[FRUIT],
                    Integer.parseInt(dividedLine[AMOUNT])
            );
            transactionsList.add(fruitTransaction);
        }

        return transactionsList;
    }
}
