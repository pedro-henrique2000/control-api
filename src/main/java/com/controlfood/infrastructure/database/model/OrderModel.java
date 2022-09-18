package com.controlfood.infrastructure.database.model;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_ORDER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    @SequenceGenerator(name = "ORDER_SEQ")
    private Long id;

    @Column(nullable = false)

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetailsModel> orderDetails;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @PrePersist
    public void onInsert() {
        this.createdAt = LocalDateTime.now();
    }

}
