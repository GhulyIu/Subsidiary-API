package com.pichincha.SubsidiaryAPI.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class GenericResponse {
    private String error;
    private String errorDetail;
}
