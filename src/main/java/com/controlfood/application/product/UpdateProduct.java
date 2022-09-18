package com.controlfood.application.product;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.protocols.UpdateProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateProduct {

    private final UpdateProductRepository updateProductRepository;
    private final FindProductById findProductById;

    public void invoke(Product product) {
        Product updated = this.updateProductRepository.update(updatedEntity(product));
        log.info("Update product with id {} to [{}]", product.getId(), updated);
    }

    private Product updatedEntity(Product product) {
        Product oldProduct = this.findProductById.invoke(product.getId());
        product.addNewTags(oldProduct.getTags());
        return Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .tags(product.getTags())
                .url(product.getUrl())
                .quantity(product.getQuantity())
                .id(product.getId())
                .status(product.getStatus())
                .build();
    }

}
