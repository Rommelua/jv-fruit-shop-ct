package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionExecutor {
    void execute(List<FruitTransaction> transactionList);
}
