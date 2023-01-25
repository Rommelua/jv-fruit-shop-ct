package db;

import java.util.HashMap;
import model.Fruit;

public class Storage {
    private HashMap<Fruit, Integer> fruitsInStorage;

    public Storage() {
        this.fruitsInStorage = new HashMap<>();
    }

    public int getFruitAmount(Fruit fruit) {
        for (Fruit searchFruit:fruitsInStorage.keySet()) {
            if (fruit.getName().equals(searchFruit.getName())) {
                return fruitsInStorage.get(getFruitWithName(fruit.getName()));
            }
        }
        return 0;
    }

    public void setFruitAmount(Fruit fruit, int amount) {
        if (fruitsInStorage.isEmpty()) {
            fruitsInStorage.put(fruit,amount);
        } else {
            Fruit insertFruit = getFruitWithName(fruit.getName());
            fruitsInStorage.put(insertFruit,amount);
        }
    }

    public Fruit getFruitWithName(String name) {
        Fruit[] fruitArray = fruitsInStorage.keySet().toArray(new Fruit[0]);
        for (int i = 0; i < fruitArray.length; i++) {
            if (name.equals(fruitArray[i].getName())) {
                return fruitArray[i];
            }
        }
        return null;
    }

    public void addFruit(Fruit fruit, int amount) {
        this.fruitsInStorage.put(fruit,amount);
    }

    public HashMap<Fruit, Integer> getFruitsInStorage() {
        return this.fruitsInStorage;
    }
}
