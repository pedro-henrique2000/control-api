package com.controlfood.infrastructure.database.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "TB_PRODUCT")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    @SequenceGenerator(name = "PRODUCT_SEQ")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    private String url;

    private StatusModel status;

    @Column(nullable = false)
    private int quantity;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ProductTag", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    private List<TagModel> tags;

}
