package com.villancio.villanciomarket.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ProductPuchasePK implements Serializable{
    
    @Column(name = "id_compra")
    private Integer idPuchase;

    @Column(name = "id_producto")
    private Integer idproduct;

}
