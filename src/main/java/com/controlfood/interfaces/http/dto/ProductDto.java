package com.controlfood.interfaces.http.dto;

import com.controlfood.interfaces.http.dto.validator.ValidEnum;
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

    private Long id;

    @NotBlank
    private String name;

    @Positive
    @NotNull
    private int quantity;

    @Size(min = 0, max = 255)
    private String description;

    @Positive
    @NotNull
    private BigDecimal price;

    @Max(value = 255)
    private String url;

    @ValidEnum(enumType = StatusDto.class)
    private StatusDto status;

    @NotEmpty
    private List<@ValidEnum(enumType = TagsDto.class) TagsDto> tags;

}
