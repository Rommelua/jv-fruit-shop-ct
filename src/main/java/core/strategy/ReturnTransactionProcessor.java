package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class ReturnTransactionProcessor implements TransactionProcessor {
    @Override
    public void process(FruitTransaction transaction, StorageDao storage) {
        storage.addToStorageFruitAndQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}

