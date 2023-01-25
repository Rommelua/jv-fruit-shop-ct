package service.impl;

import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.OperationHandler;
import service.TransactionExecutor;
import strategy.BalanceOperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class TransactionExecutorImpl implements TransactionExecutor {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;
    private Storage storage;

    public TransactionExecutorImpl(Storage storage) {
        this.operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        this.storage = storage;
    }

    @Override
    public Storage execute(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            operationHandlers.get(transaction.getOperation()).executeOperation(transaction,storage);
        }
        return storage;
    }
}
