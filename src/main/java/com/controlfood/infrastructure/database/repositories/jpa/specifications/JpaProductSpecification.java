package com.controlfood.infrastructure.database.repositories.jpa.specifications;

import com.controlfood.infrastructure.database.model.ProductModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class JpaProductSpecification implements Specification<ProductModel> {

    private List<SearchCriteria> criterias;

    public JpaProductSpecification(List<SearchCriteria> list) {
        this.criterias = list;
    }

    @Override
    public Predicate toPredicate(Root<ProductModel> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : criterias) {
            switch (criteria.getOperation()) {
                case GREATER_THAN -> predicates.add(builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
                case LESS_THAN -> predicates.add(builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
                case GREATER_THAN_EQUAL -> predicates.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
                case LESS_THAN_EQUAL -> predicates.add(builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
                case NOT_EQUAL -> predicates.add(builder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
                case EQUAL -> predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
                case LIKE -> predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%"));
                case LIKE_END -> predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), criteria.getValue().toString().toLowerCase() + "%"));
                case LIKE_START -> predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase()));
                case IN -> predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
                case NOT_IN -> predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
