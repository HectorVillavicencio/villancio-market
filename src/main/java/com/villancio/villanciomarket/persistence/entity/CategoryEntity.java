package com.villancio.villanciomarket.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private boolean state;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

}
