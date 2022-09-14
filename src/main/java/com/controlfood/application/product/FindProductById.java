package com.controlfood.application.product;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.errors.ResourceNotFoundException;
import com.controlfood.domain.protocols.FindByProductByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindProductById {

    private final FindByProductByIdRepository findByProductByIdRepository;

    public Product invoke(Long id) {
        Product product = findByProductByIdRepository.findById(id);
        if (product == null) {
            throw new ResourceNotFoundException("Not found product with id " + id);
        } else {
            return product;
        }
    }

}
