package controller;

import model.Fruit;
import model.FruitTransaction;

public class Balance implements OperationStrategy {
    @Override
    public Fruit executeOperation(FruitTransaction transaction, Fruit fruitAmount) {
        Fruit fruitToInsert = new Fruit(transaction.getFruit(), transaction.getQuantity());
        return fruitToInsert;
    }
}
