package com.controlfood.domain.protocols;

import com.controlfood.domain.entities.Product;

public interface UpdateProductRepository {

    Product update(Product product);

}
