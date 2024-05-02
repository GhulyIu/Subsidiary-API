package com.pichincha.SubsidiaryAPI.DTO;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubsidiaryDTO {
    private Integer id;
    private String ruc;
    private String nombre;
    private String tipo;
    private String direccion;
    private String giroNegocio;
    private String propietario;



}
