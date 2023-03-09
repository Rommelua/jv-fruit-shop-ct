package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class BalanceTransactionProcessor implements TransactionProcessor {
    public BalanceTransactionProcessor(StorageDao storageDao) {
    }

    @Override
    public void process(FruitTransaction transaction, StorageDao storageDao) {
        storageDao.set(transaction.getFruit(), transaction.getQuantity());
    }
}
