package com.controlfood.interfaces.http.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class ProductDto {

    @NotBlank
    private String name;

    @Max(value = 255)
    private String description;

    @Positive
    @NotNull
    private BigDecimal price;

    @Max(value = 255)
    private String url;

    @NotNull
    private StatusDto status;

    @NotEmpty
    private List<@NotNull TagsDto> tags;

}
