package controller;

import model.Fruit;
import model.FruitTransaction;

public class Supply implements OperationStrategy {
    @Override
    public int executeOperation(FruitTransaction transaction, Fruit fruit) {
        int supplyAmount = transaction.getQuantity() + fruit.getAmount();
        return supplyAmount;
    }
}
