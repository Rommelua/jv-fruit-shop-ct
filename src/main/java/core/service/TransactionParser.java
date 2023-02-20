package core.service;

import core.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParser {

    public List<FruitTransaction> parser(List<String> data) {
        List<FruitTransaction> transactionsList = new ArrayList<>();
        String[] splittedLine = null;
        FruitTransaction fruitTransaction;
        for (int i = 1; i < data.size(); i++) {
            splittedLine = data.get(i).split(","); // тут в splittedLine буде: b banana 20
            fruitTransaction = new FruitTransaction(
                    FruitTransaction.Operation.stringToOperation(splittedLine[0]),
                    splittedLine[1],
                    Integer.parseInt(splittedLine[2])
            );
            transactionsList.add(fruitTransaction);
        }

        return transactionsList;
    }
}
