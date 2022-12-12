package controller;

import model.Fruit;
import model.FruitTransaction;

/*
 * Implementation of this Interface determine available operations for the Store
 */
public interface OperationStrategy {
    Fruit executeOperation(FruitTransaction transaction, Fruit fruit);
}
