package com.pichincha.SubsidiaryAPI.DTO;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoDTO {

    private Integer id;
    private String ruc;
    private String nombre;
    private double latitud;
    private double longitud;

}
