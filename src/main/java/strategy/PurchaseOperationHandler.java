package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Storage storage) {
        int operationResult = storage.getFruitAmount(transaction.getFruit())
                - transaction.getQuantity();
        storage.setFruitAmount(transaction.getFruit(),operationResult);
    }
}
