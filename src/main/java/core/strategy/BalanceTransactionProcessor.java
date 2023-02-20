package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class BalanceTransactionProcessor implements TransactionProcessor {
    @Override
    public void process(FruitTransaction transaction, StorageDao storage) {
        storage.putToStorageFruitAndQuantity(transaction.getFruit(), transaction.getQuantity());
    }

}
