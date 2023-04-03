package core.strategy;

import core.model.FruitTransaction;

public interface TransactionProcessor {
    void process(FruitTransaction transaction);
}
