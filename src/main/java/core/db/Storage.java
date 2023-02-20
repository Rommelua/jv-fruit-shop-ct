package core.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> mapOfFruits = new HashMap<>();

    public Storage() {
    }

    public Storage(Map<String, Integer> mapOfFruits) {
        this.mapOfFruits = mapOfFruits;
    }

    public Map<String, Integer> getMapOfFruits() {
        return mapOfFruits;
    }

    public void setMapOfFruits(Map<String, Integer> mapOfFruits) {
        this.mapOfFruits = mapOfFruits;
    }

    @Override
    public String toString() {
        return "Storage{"
                + "mapOfFruits="
                + mapOfFruits
                + '}';
    }
}
