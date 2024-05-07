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

    @ManyToOne
    @MapsId("idPuchase")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private PuchaseEntity puchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private ProductEntity product;

}
