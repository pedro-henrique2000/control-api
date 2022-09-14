package com.controlfood.infrastructure.database.repositories.jpa.specifications;

import com.controlfood.infrastructure.database.model.ProductModel;
import com.controlfood.infrastructure.database.model.StatusModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class JpaProductSpecification implements Specification<ProductModel> {

    private static final String STATUS = "status";

    @Override
    public Predicate toPredicate(Root<ProductModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get(STATUS), StatusModel.ACTIVE.getCode());
    }

}
