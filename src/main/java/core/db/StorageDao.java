package core.db;

import java.util.Map;

public class StorageDao {
    private static Storage storage = new Storage();

    public StorageDao() {
    }

    public StorageDao(Storage storage) {
        StorageDao.storage = storage;
    }

    public void set(String fruit, int quantity) {
        storage.getMapOfFruits().put(fruit, quantity);
    }

    public int get(String fruit) {
        return storage.getMapOfFruits().get(fruit);
    }

    public void getAll(Map<String, Integer> fruit) {
        for (String fruits : fruit.keySet()) {
            storage.getMapOfFruits().get(fruits);
        }
    }

    public Map<String, Integer> getAllFruits() {
        return storage.getMapOfFruits();
    }
}
