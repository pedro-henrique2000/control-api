package com.controlfood.infrastructure.database.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_ORDER_DETAILS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderDetailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_DETAILS_SEQ")
    @SequenceGenerator(name = "ORDER_DETAILS_SEQ")
    private Long id;

    @ManyToOne
    private ProductModel product;

    @Column(nullable = false)
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDetailsModel that = (OrderDetailsModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
