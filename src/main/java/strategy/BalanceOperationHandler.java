package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private Storage storage;

    public BalanceOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void executeOperation(FruitTransaction transaction) {
        storage.setFruitAmount(transaction.getFruit(),transaction.getQuantity());
    }
}
