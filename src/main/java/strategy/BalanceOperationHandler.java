package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Storage storage) {
        storage.setFruitAmount(transaction.getFruit(),transaction.getQuantity());
    }
}
