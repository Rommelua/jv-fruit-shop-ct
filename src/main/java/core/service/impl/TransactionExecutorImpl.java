package core.service.impl;

import core.db.StorageDao;
import core.model.FruitTransaction;
import core.service.TransactionExecutor;
import core.strategy.Strategy;
import java.util.List;

public class TransactionExecutorImpl implements TransactionExecutor {
    private final Strategy strategy;

    public TransactionExecutorImpl(StorageDao storageDao) {
        strategy = new Strategy();
    }

    @Override
    public void executeTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategy.getTransactionProcessor(transaction.getOperation()).process(transaction);
        }
    }
}
