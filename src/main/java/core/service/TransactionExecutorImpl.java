package core.service;

import core.model.FruitTransaction;
import core.service.interfaces.TransactionExecutor;
import core.strategy.Strategy;
import java.util.List;

public class TransactionExecutorImpl implements TransactionExecutor {
    private final Strategy strategy;

    public TransactionExecutorImpl() {
        strategy = new Strategy();
    }

    @Override
    public void executeTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategy.getTransactionProcessor(transaction.getOperation()).process(transaction);
        }
    }
}
