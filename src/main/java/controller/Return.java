package controller;

import model.Fruit;
import model.FruitTransaction;

public class Return implements OperationStrategy {
    @Override
    public int executeOperation(FruitTransaction transaction, Fruit fruit) {
        int returnAmount = transaction.getQuantity() + fruit.getAmount();
        return returnAmount;
    }
}
