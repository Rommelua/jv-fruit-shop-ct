package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public interface TransactionProcessor {
    void process(FruitTransaction transaction, StorageDao storageDao);
}
