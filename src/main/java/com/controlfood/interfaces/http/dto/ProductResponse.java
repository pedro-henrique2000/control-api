package com.controlfood.interfaces.http.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

    private long id;

    private String name;

    private int quantity;

    private String description;

    private BigDecimal price;

    private String url;

    private StatusDto status;

    private List<TagsDto> tags;

}
