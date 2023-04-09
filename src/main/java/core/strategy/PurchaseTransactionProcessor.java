package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;
import core.service.interfaces.TransactionProcessor;

public class PurchaseTransactionProcessor implements TransactionProcessor {
    private final StorageDao storageDao;

    public PurchaseTransactionProcessor() {
        storageDao = new StorageDao();
    }

    @Override
    public void process(FruitTransaction transaction) {
        storageDao.set(transaction.getFruit(), storageDao.get(transaction.getFruit()) - transaction.getQuantity());
    }
}
