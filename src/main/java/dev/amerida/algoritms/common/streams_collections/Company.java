package dev.amerida.algoritms.common.streams_collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Company implements ICompany {
    private final List<ICategory> categories;

    public Company(List<ICategory> categories) {
        this.categories = categories;
    }

    @Override
    public List<IProduct> getAllProductsWithMultipleCategories() {
        Map<IProduct, Long> productsWithMultipleCategories = categories.stream()
                .flatMap(cat -> cat.getProducts().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return productsWithMultipleCategories.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .distinct()
                .sorted(Comparator.comparing(IProduct::getName))
                .toList();
    }

    @Override
    public List<Node> getAllCategoriesWithTotalPrice() {
        return categories.stream()
                .map(cat -> new Node(
                        cat.getName(),
                        cat.getProducts().stream()
                                .mapToDouble(IProduct::getPrice)
                                .sum()
                        ))
                .sorted(Comparator.comparingDouble(Node::getTotalValue).reversed())
                .toList();
    }

    @Override
    public Node getMostValuableCategory() {
        return this.getAllCategoriesWithTotalPrice()
                .stream()
                .findFirst()
                .orElse(null);
    }

    static void main() {
        List<IProduct> productsList1 = List.of(
                new Product(1, "banana", 10),
                new Product(2, "apple", 15),
                new Product(3, "orange", 20)
        );

        List<IProduct> productsList2 = List.of(
                new Product(4, "table", 150),
                new Product(5, "chair", 50),
                new Product(6, "armchair", 100),
                new Product(1, "banana", 10)
        );

        List<IProduct> productsList3 = List.of(
                new Product(7, "television", 200),
                new Product(8, "monitor", 100),
                new Product(9, "iphone 17 Pro", 10),
                new Product(3, "orange", 20)
        );

        List<ICategory> categories = List.of(
                new Category(1, "fruits", productsList1),
                new Category(2, "furnitures", productsList2),
                new Category(3, "electronics", productsList3)
        );

        Company company = new Company(categories);
        IO.println("Products with multiple categories: " + company.getAllProductsWithMultipleCategories());

        IO.println("Get all categories with total price of their products: " + company.getAllCategoriesWithTotalPrice());

        IO.println("Most valuable category: " + company.getMostValuableCategory());
        IO.println();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (ICategory category : categories) {
            for (IProduct product : category.getProducts()) {
                Objects.requireNonNull(map.computeIfAbsent(category.getId(),
                        k -> new ArrayList<>())).add(product.getId());
            }
        }

        IO.println(map);
    }
}
