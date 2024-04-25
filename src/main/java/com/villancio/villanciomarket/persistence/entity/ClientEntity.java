package com.villancio.villanciomarket.persistence.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "clientes")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apeliidos")
    private String lastName;

    @Column(name = "celular")
    private Integer cell;

    @Column(name = "direccion")
    private String address;

    @Column(name = "correo_electronico")
    private String mail;

    @OneToMany( mappedBy = "client")
    private List<PuchaseEntity> puchases;

}
