package db;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class Storage {
    private Map<Fruit, Integer> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    public int getFruitAmount(Fruit fruit) {
        return storage.get(fruit);
    }

    public void setFruitAmount(Fruit fruit, int amount) {
        storage.put(fruit,amount);
    }

    public Map<Fruit,Integer> getAllFruits() {
        return storage;
    }

}
