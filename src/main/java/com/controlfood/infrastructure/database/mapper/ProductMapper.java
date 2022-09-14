package com.controlfood.infrastructure.database.mapper;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.entities.Status;
import com.controlfood.domain.entities.Tags;
import com.controlfood.infrastructure.database.model.ProductModel;
import com.controlfood.infrastructure.database.model.StatusModel;
import com.controlfood.infrastructure.database.model.TagModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductModel toModel(Product product) {
        List<TagModel> tagModels = product.getTags().stream().map(tag -> TagModel.valueOf(tag.name())).toList();
        ProductModel productModel = new ProductModel();
        productModel.setDescription(product.getDescription());
        productModel.setId(product.getId());
        productModel.setName(product.getName());
        productModel.setPrice(product.getPrice());
        productModel.setStatus(StatusModel.valueOf(product.getStatus().name()));
        productModel.setUrl(product.getUrl());
        productModel.setTags(tagModels);
        productModel.setQuantity(product.getQuantity());
        return productModel;
    }

    public Product toEntity(ProductModel productModel) {
        List<Tags> tags = productModel.getTags().stream().map(tag -> Tags.valueOf(tag.name())).toList();
        return Product.builder()
                .name(productModel.getName())
                .price(productModel.getPrice())
                .url(productModel.getUrl())
                .description(productModel.getDescription())
                .id(productModel.getId())
                .tags(tags)
                .quantity(productModel.getQuantity())
                .status(Status.valueOf(productModel.getStatus().name()))
                .build();
    }

}
