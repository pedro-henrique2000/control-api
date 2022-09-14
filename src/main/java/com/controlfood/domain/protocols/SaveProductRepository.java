package com.controlfood.domain.protocols;

import com.controlfood.domain.entities.Product;

public interface SaveProductRepository {

    Product save(Product product);

}
