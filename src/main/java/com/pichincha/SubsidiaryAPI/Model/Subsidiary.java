package com.pichincha.SubsidiaryAPI.Model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "SUBSIDIARY")

public class Subsidiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "RUC")
    private String ruc;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "GIRO_NEGOCIO")
    private String giroNegocio;

    @Column(name = "LATITUD")
    private String latitud;

    @Column(name = "LONGITUD")
    private String longitud;

    @Column(name = "PROPETARIO")
    private String propietario;

}
