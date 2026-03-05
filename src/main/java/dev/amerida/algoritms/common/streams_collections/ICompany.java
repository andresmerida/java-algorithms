package dev.amerida.algoritms.common.streams_collections;

import java.util.List;

public interface ICompany {


    List<IProduct> getAllProductsWithMultipleCategories();
    List<Node> getAllCategoriesWithTotalPrice();
    Node getMostValuableCategory();
}
