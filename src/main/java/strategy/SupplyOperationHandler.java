package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private Storage storage;

    public SupplyOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void executeOperation(FruitTransaction transaction) {
        int supplyAmount = transaction.getQuantity()
                + storage.getFruitAmount(transaction.getFruit());
        storage.setFruitAmount(transaction.getFruit(),supplyAmount);
    }
}
