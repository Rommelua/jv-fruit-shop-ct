package core.db;

import java.util.HashMap;
import java.util.Map;

public class StorageDao {
    private static final Storage storage = new Storage();

    public StorageDao() {
    }

    public void set(String fruit, int quantity) {
        storage.getMapOfFruits().put(fruit, quantity);
    }

    public int get(String fruit) {
        return storage.getMapOfFruits().get(fruit);
    }

    public Map<String, Integer> getAllFruits() {
        return new HashMap<>(storage.getMapOfFruits());
    }
}
