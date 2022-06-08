package com.platzi.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String id;

    private String nombre;

    private String apellidos;

    private BigDecimal celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

}
