package core.service.interfaces;

import core.model.FruitTransaction;

public interface TransactionProcessor {
    void process(FruitTransaction transaction);
}
