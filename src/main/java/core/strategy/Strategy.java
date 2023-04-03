package core.strategy;

import core.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Strategy {
    private static final Map<FruitTransaction.Operation, TransactionProcessor> processors = new HashMap<>();

    static {
        processors.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionProcessor());
        processors.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionProcessor());
        processors.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionProcessor());
        processors.put(FruitTransaction.Operation.RETURN, new ReturnTransactionProcessor());
    }

    public TransactionProcessor getTransactionProcessor(FruitTransaction.Operation operation) {
        return processors.get(operation);
    }
}
