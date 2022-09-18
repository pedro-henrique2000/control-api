package com.controlfood.domain.entities;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

@Builder
@Getter
public class Product implements DomainEntity {

    private Long id;
    private String name;
    private int quantity;
    private String description;
    private BigDecimal price;
    private String url;
    private Status status;
    private Set<Tags> tags;

    public Set<Tags> getTags() {
        return Collections.unmodifiableSet(this.tags);
    }

    public void addNewTags(Set<Tags> tagsToAdd) {
        this.tags.addAll(tagsToAdd);
    }

}
