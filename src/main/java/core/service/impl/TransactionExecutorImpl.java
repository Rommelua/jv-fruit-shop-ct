package core.service.impl;

import core.db.StorageDao;
import core.model.FruitTransaction;
import core.service.TransactionExecutor;
import core.strategy.Strategy;
import java.util.List;

public class TransactionExecutorImpl implements TransactionExecutor {

    private Strategy strategy;
    private StorageDao storage;

    @Override
    public StorageDao executeTransactions(List<FruitTransaction> transactions) {
        strategy = new Strategy();
        storage = new StorageDao();
        for (int i = 0; i < transactions.size(); i++) {
            strategy.operation = transactions.get(i).getOperation();
            strategy.pickAndExecuteStrategy(transactions.get(i), storage);
        }
        return storage;
    }
}
