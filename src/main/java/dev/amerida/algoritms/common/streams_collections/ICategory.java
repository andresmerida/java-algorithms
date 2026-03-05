package dev.amerida.algoritms.common.streams_collections;

import java.util.List;

public interface ICategory {
    int getId();
    String getName();
    List<IProduct> getProducts();
}
