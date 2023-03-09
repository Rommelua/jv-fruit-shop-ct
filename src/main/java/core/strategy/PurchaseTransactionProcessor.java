package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class PurchaseTransactionProcessor implements TransactionProcessor {

    public PurchaseTransactionProcessor(StorageDao storageDao) {
    }

    @Override
    public void process(FruitTransaction transaction, StorageDao storageDao) {
        storageDao.set(transaction.getFruit(), storageDao.get(transaction.getFruit()) - transaction.getQuantity());
    }
}
