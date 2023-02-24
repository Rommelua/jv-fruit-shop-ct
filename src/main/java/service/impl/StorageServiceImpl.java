package service.impl;

import db.Storage;
import java.util.List;
import model.FruitTransaction;
import service.StorageService;

public class StorageServiceImpl implements StorageService {
    @Override
    public Storage createStorage(List<FruitTransaction> transactionList) {
        Storage localStorage = new Storage();
        return localStorage;
    }
}
