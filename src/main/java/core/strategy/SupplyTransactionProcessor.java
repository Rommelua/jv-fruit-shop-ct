package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class SupplyTransactionProcessor implements TransactionProcessor {
    private final StorageDao storageDao;

    public SupplyTransactionProcessor() {
        storageDao = new StorageDao();
    }

    @Override
    public void process(FruitTransaction transaction) {
        storageDao.set(transaction.getFruit(), storageDao.get(transaction.getFruit()) + transaction.getQuantity());
    }
}
