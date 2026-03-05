package dev.amerida.algoritms.common.streams_collections;

public class Node {
    String categoryName;
    double totalValue;

    public Node(String categoryName, double totalValue) {
        this.categoryName = categoryName;
        this.totalValue = totalValue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getTotalValue() {
        return totalValue;
    }

    @Override
    public String toString() {
        return String.format("%s : %.2f", categoryName, totalValue);
    }
}
