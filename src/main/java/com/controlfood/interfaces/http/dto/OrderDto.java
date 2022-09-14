package com.controlfood.interfaces.http.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    @NotNull
    @Positive
    private Long productId;

    @Positive
    @NotNull
    private int quantity;

}
