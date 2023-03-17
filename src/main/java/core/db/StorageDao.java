package core.db;

import java.util.HashMap;
import java.util.Map;

public class StorageDao {
    private static Storage storage = new Storage();
    private Map<String, Integer> mapOfFruitsDao = new HashMap<>();

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

    public Map<String, Integer> getAllFruits() {
        mapOfFruitsDao = storage.getMapOfFruits();
        return mapOfFruitsDao;
    }
}
