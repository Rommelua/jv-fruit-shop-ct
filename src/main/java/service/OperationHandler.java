package service;

import db.Storage;
import model.FruitTransaction;

public interface OperationHandler {
    void executeOperation(FruitTransaction transaction, Storage storage);
}
