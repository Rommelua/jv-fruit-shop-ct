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
        if (operationResult < 0) {
            throw new RuntimeException("Transaction can`t be executed for "
                   + transaction.getFruit() + ". Purchase amount "
                   + transaction.getQuantity() + "exceeds fruit amount in the Storage "
                   + storage.getFruitAmount(transaction.getFruit()));
        }
        storage.setFruitAmount(transaction.getFruit(), operationResult);
    }
}
