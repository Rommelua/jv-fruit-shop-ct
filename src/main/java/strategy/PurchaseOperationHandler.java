package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private Storage storage;

    public PurchaseOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void executeOperation(FruitTransaction transaction) {
        int operationResult = storage.getFruitAmount(transaction.getFruit())
                - transaction.getQuantity();
        storage.setFruitAmount(transaction.getFruit(),operationResult);
    }
}
