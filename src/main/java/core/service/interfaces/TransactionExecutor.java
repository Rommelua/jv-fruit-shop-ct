package core.service.interfaces;

import core.model.FruitTransaction;
import java.util.List;

public interface TransactionExecutor {
    void executeTransactions(List<FruitTransaction> transactions);
}
