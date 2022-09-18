package com.controlfood.interfaces.http.mapper;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.entities.Status;
import com.controlfood.domain.entities.Tags;
import com.controlfood.interfaces.http.dto.ProductDto;
import com.controlfood.interfaces.http.dto.ProductResponse;
import com.controlfood.interfaces.http.dto.StatusDto;
import com.controlfood.interfaces.http.dto.TagsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductDtoMapper {

    public Product toEntity(ProductDto productDto) {
        Set<Tags> tags = productDto.getTags().stream().map(tag -> {
            return Tags.of(tag.name());
        }).collect(Collectors.toSet());
        Status status = Status.of(productDto.getStatus().name());
        return Product.builder()
                .id(productDto.getId())
                .description(productDto.getDescription())
                .url(productDto.getUrl())
                .quantity(productDto.getQuantity())
                .price(productDto.getPrice())
                .name(productDto.getName())
                .tags(tags)
                .status(status)
                .build();
    }

    public ProductResponse toProducResponse(Product product) {
        List<TagsDto> tagsDtos = product.getTags().stream().map(tag -> {
            return TagsDto.valueOf(tag.name());
        }).collect(Collectors.toList());
        ProductResponse response = new ProductResponse();
        response.setStatus(StatusDto.from(product.getStatus().name()));
        response.setTags(tagsDtos);
        response.setName(product.getName());
        response.setId(product.getId());
        response.setPrice(product.getPrice());
        response.setUrl(product.getUrl());
        response.setDescription(product.getDescription());
        response.setQuantity(product.getQuantity());
        return response;
    }

}
