package controller;

import model.Fruit;
import model.FruitTransaction;

public class Return implements OperationStrategy {
    @Override
    public Fruit executeOperation(FruitTransaction transaction, Fruit fruit) {
        Fruit fruitToInsert = new Fruit(transaction.getFruit(),fruit.getAmount()
                + transaction.getQuantity());
        return fruitToInsert;
    }
}
