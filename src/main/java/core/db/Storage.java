package core.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> mapOfFruits = new HashMap<>();

    public Storage() {
    }

    public Map<String, Integer> getMapOfFruits() {
        return mapOfFruits;
    }
}
