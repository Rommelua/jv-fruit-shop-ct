package model;

import java.util.Objects;

public class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Fruit fruit = (Fruit) obj;
        return Objects.equals(name, fruit.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
