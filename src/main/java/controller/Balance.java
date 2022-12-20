package controller;

import model.Fruit;
import model.FruitTransaction;

public class Balance implements OperationStrategy {
    @Override
    public int executeOperation(FruitTransaction transaction, Fruit fruitAmount) {
        int balance = transaction.getQuantity();
        return balance;
    }
}
