package service.impl;

import db.Storage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Fruit;
import model.FruitTransaction;
import service.StorageService;

public class StorageServiceImpl implements StorageService {
    @Override
    public Storage createStorage(List<FruitTransaction> transactionList) {
        Storage localStorage = new Storage();
        Set<String> uniqueFruitNames = new HashSet<>();
        for (FruitTransaction transaction : transactionList) {
            uniqueFruitNames.add(transaction.getFruit().getName());
        }
        for (String fruitName: uniqueFruitNames) {
            localStorage.addFruit(new Fruit(fruitName),0);
        }
        return localStorage;
    }
}
