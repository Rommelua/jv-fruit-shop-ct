package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class ReturnTransactionProcessor implements TransactionProcessor {
    private StorageDao storage;

    public ReturnTransactionProcessor(StorageDao storage) {
    }

    @Override
    public void process(FruitTransaction transaction, StorageDao storage) {
        storage.set(transaction.getFruit(), storage.get(transaction.getFruit()) + transaction.getQuantity());
    }
}

