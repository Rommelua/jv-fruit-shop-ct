package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Storage storage) {
        int supplyAmount = transaction.getQuantity()
                + storage.getFruitAmount(transaction.getFruit());
        storage.setFruitAmount(transaction.getFruit(),supplyAmount);
    }
}
