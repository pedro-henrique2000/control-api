package com.controlfood.infrastructure.database.repositories.jpa.specifications;

import com.controlfood.domain.entities.search.ProductSearch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.controlfood.infrastructure.database.repositories.jpa.specifications.SearchOperation.*;

@Component
public class ProductSpecificationBuilder {

    private static final String STATUS = "status";
    private static final String NAME = "name";
    private static final String PRICE = "price";

    public List<SearchCriteria> buildSearchCriterias(final ProductSearch productSearch) {
        List<SearchCriteria> criterias = new ArrayList<>();
        SearchCriteria activeProductCriteria = new SearchCriteria(STATUS, 1, EQUAL);
        criterias.add(activeProductCriteria);
        if (productSearch.getName() != null) {
            SearchCriteria nameCriteria = new SearchCriteria(NAME, productSearch.getName(), LIKE);
            criterias.add(nameCriteria);
        }
        if (productSearch.getPrice() != null) {
            SearchCriteria priceCriteria = new SearchCriteria(PRICE, productSearch.getPrice(), LESS_THAN_EQUAL);
            criterias.add(priceCriteria);
        }
        return criterias;
    }

}
