package service;

import db.Storage;
import java.util.List;
import model.FruitTransaction;

public interface StorageService {
    Storage createStorage(List<FruitTransaction> transactionList);
}
