package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;

public class Storage {
    private Map<Fruit, Integer> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    public int getFruitAmount(Fruit fruit) {
        for (Fruit searchFruit : storage.keySet()) {
            if (fruit.equals(searchFruit)) {
                return storage.get(searchFruit);
            }
        }
        return 0;
    }

    public void setFruitAmount(Fruit fruit, int amount) {
        if (!storage.containsKey(fruit)) {
            storage.put(fruit,amount);
        } else {
            storage.replace(fruit,amount);
        }
    }

    public List<String> getAllFruits() {
        List<String> fruitList = new ArrayList<>();
        for (Fruit fruit: storage.keySet()) {
            String temp = new String();
            temp = fruit.getName() + "," + storage.get(fruit) + System.lineSeparator();
            fruitList.add(temp);
        }
        return fruitList;
    }

}
