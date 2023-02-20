package core.db;

public class StorageDao extends Storage {
    public void putToStorageFruitAndQuantity(String fruit, int quantity) {
        getMapOfFruits().put(fruit,quantity);
    }

    public void addToStorageFruitAndQuantity(String fruit, int quantity) {
        getMapOfFruits().put(fruit, getMapOfFruits().get(fruit) + quantity);
    }

    public void removeFromStorFruAndQuan(String fruit, int quantity) {
        getMapOfFruits().put(fruit, getMapOfFruits().get(fruit) - quantity);
    }
}
