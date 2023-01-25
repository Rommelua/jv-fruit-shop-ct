package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Storage storage) {
        int operationResult = transaction.getQuantity()
                + storage.getFruitAmount(transaction.getFruit());
        storage.setFruitAmount(transaction.getFruit(),operationResult);
    }
}
