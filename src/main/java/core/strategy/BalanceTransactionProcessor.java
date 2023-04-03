package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class BalanceTransactionProcessor implements TransactionProcessor {
    private final StorageDao storageDao;

    public BalanceTransactionProcessor() {
        storageDao = new StorageDao();
    }

    @Override
    public void process(FruitTransaction transaction) {
        storageDao.set(transaction.getFruit(), transaction.getQuantity());
    }
}
