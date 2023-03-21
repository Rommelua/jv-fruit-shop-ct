package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private Storage storage;

    public ReturnOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void executeOperation(FruitTransaction transaction) {
        int operationResult = transaction.getQuantity()
                + storage.getFruitAmount(transaction.getFruit());
        storage.setFruitAmount(transaction.getFruit(), operationResult);
    }
}
