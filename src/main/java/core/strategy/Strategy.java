package core.strategy;

import core.db.StorageDao;
import core.model.FruitTransaction;

public class Strategy {
    public FruitTransaction.Operation operation;

    public Strategy() {
    }

    public Strategy(FruitTransaction.Operation operation) {
        this.operation = operation;
    }

    public void pickAndExecuteStrategy(FruitTransaction transaction, StorageDao storage) {
        switch (operation.getOperation()) {
            case "b": // тоді замість "b" буде BALANCE - СПРОБУВАТИ!!
                BalanceTransactionProcessor countBalance = new BalanceTransactionProcessor();
                countBalance.process(transaction, storage);
                break;
            case "p":
                PurchaseTransactionProcessor countPurchase = new PurchaseTransactionProcessor();
                countPurchase.process(transaction, storage);
                break;
            case "s":
                SupplyTransactionProcessor countSupply = new SupplyTransactionProcessor();
                countSupply.process(transaction, storage);
                break;
            case "r":
                ReturnTransactionProcessor countReturn = new ReturnTransactionProcessor();
                countReturn.process(transaction, storage);
                break;
            default:
        }
    }
}
