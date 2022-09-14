package com.controlfood.application.product;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.protocols.FindAllProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllProducts {

    private final FindAllProductRepository findAllProductRepository;

    public List<Product> invoke() {
        return findAllProductRepository.findAll();
    }

}
