package model;

import db.Storage;
import service.OperationHandler;

public class Store {
    private Storage storage;
    private OperationHandler strategy;

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public OperationHandler getStrategy() {
        return strategy;
    }

    public void setStrategy(OperationHandler strategy) {
        this.strategy = strategy;
    }

}
