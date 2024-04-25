package com.villancio.villanciomarket.persistence.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "categorias")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategory;

    @Column(name = "descripcion")
    private String description;

    @Column (name = "estado")
    private String state;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

}
