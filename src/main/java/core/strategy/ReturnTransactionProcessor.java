package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class ReturnTransactionProcessor implements TransactionProcessor {
    public ReturnTransactionProcessor(StorageDao storageDao) {
    }

    @Override
    public void process(FruitTransaction transaction, StorageDao storageDao) {
        storageDao.set(transaction.getFruit(), storageDao.get(transaction.getFruit()) + transaction.getQuantity());
    }
}

