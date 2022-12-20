package controller;

import model.Fruit;
import model.FruitTransaction;

public class Purchase implements OperationStrategy {
    @Override
    public int executeOperation(FruitTransaction transaction, Fruit fruit) {
        int purchaseAmount = fruit.getAmount() - transaction.getQuantity();
        return purchaseAmount;
    }
}
