package core.strategy;

import core.db.Storage;
import core.db.StorageDao;
import core.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Strategy {
    private static final Map<FruitTransaction.Operation, TransactionProcessor> processors = new HashMap<>();

    static {
        StorageDao storageDao = new StorageDao(new Storage());
        processors.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionProcessor(storageDao));
        processors.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionProcessor(storageDao));
        processors.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionProcessor(storageDao));
        processors.put(FruitTransaction.Operation.RETURN, new ReturnTransactionProcessor(storageDao));
    }

    public TransactionProcessor getTransactionProcessor(FruitTransaction.Operation operation) {
        return processors.get(operation);
    }
}
