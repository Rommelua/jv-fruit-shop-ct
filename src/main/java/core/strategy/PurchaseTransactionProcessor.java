package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class PurchaseTransactionProcessor implements TransactionProcessor {
    @Override
    public void process(FruitTransaction transaction, StorageDao storage) {
        storage.removeFromStorFruAndQuan(transaction.getFruit(), transaction.getQuantity());
    }
}
