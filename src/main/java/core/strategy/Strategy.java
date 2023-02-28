package core.strategy;

import core.db.Storage;
import core.db.StorageDao;
import core.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Strategy {
    private static final Map<FruitTransaction.Operation, TransactionProcessor> processors = new HashMap<>();

    static {
        StorageDao storage = new StorageDao(new Storage());
        processors.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionProcessor(storage));
        processors.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionProcessor(storage));
        processors.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionProcessor(storage));
        processors.put(FruitTransaction.Operation.RETURN, new ReturnTransactionProcessor(storage));
    }

    public TransactionProcessor getTransactionProcessor(FruitTransaction.Operation operation) {
        return processors.get(operation);
    }
}
