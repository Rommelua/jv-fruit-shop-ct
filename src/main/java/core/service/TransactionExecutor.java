package core.service;

import core.db.StorageDao;
import core.model.FruitTransaction;
import java.util.List;

public interface TransactionExecutor {
    StorageDao executeTransactions(List<FruitTransaction> transactions);
}
