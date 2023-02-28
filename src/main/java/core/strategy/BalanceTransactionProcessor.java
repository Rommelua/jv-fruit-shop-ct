package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class BalanceTransactionProcessor implements TransactionProcessor {
    private StorageDao storage;

    public BalanceTransactionProcessor(StorageDao storage) {
    }

    public void process(FruitTransaction transaction, StorageDao storage) {
        storage.set(transaction.getFruit(), transaction.getQuantity());
    }

}
