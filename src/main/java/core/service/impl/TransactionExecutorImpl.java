package core.service.impl;

import core.db.StorageDao;
import core.model.FruitTransaction;
import core.service.TransactionExecutor;
import core.strategy.Strategy;
import core.strategy.TransactionProcessor;
import java.util.List;

public class TransactionExecutorImpl implements TransactionExecutor {
    private final Strategy strategy = new Strategy();

    @Override
    public void executeTransactions(List<FruitTransaction> transactions, StorageDao storage) {
        for (FruitTransaction transaction : transactions) {
            TransactionProcessor processor = strategy.getTransactionProcessor(transaction.getOperation());
            processor.process(transaction, storage);
        }
    }
}
