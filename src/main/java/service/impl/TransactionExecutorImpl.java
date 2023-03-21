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
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storage));
    }

    @Override
    public void execute(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            operationHandlers.get(transaction.getOperation()).executeOperation(transaction);
        }
    }
}
