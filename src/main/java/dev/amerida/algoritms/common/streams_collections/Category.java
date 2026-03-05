package dev.amerida.algoritms.common.streams_collections;

import java.util.List;
import java.util.Objects;

public class Category implements ICategory {
    private final int id;
    private final String name;
    private final List<IProduct> products;

    public Category(int id, String name, List<IProduct> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<IProduct> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", id, name);
    }
}
