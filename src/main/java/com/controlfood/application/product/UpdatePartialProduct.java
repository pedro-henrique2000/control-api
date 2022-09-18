package com.controlfood.application.product;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.errors.BusinessException;
import com.controlfood.domain.protocols.UpdateProductRepository;
import com.controlfood.interfaces.http.dto.ProductPartialDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdatePartialProduct {

    private final UpdateProductRepository updateProductRepository;
    private final FindProductById findProductById;

    public void invoke(Long id, ProductPartialDTO productPartialDTO) {
        Product product = findProductById.invoke(id);
        try {
            for (Method method : productPartialDTO.getClass().getDeclaredMethods()) {
                Object result = method.invoke(productPartialDTO);
                if (result != null) {
                    product.assingValue(method.getName().replace("get", "").toLowerCase(), result);
                }
            }
            this.updateProductRepository.update(product);
            log.info("Updated partial product");
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new BusinessException("");
        }
    }
}
