package service;

import db.Storage;
import java.util.List;
import model.FruitTransaction;

public interface TransactionExecutor {
    Storage execute(List<FruitTransaction> transactionList);
}
