package com.villancio.villanciomarket.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class ProductPuchaseEntity {
    @EmbeddedId
    private ProductPuchasePK id;

    @Column(name = "cantidad")
    private Integer cant;

    private Double total;

    @Column(name = "estado")
    private Boolean state;
}
