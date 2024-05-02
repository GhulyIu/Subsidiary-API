package com.pichincha.SubsidiaryAPI.Service;

import com.pichincha.SubsidiaryAPI.DTO.GenericResponse;
import com.pichincha.SubsidiaryAPI.DTO.GeoDTO;
import com.pichincha.SubsidiaryAPI.DTO.SubsidiaryDTO;
import com.pichincha.SubsidiaryAPI.Model.Subsidiary;
import com.pichincha.SubsidiaryAPI.Repository.SubsidiaryRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubsidiaryService {

    @Autowired
    private SubsidiaryRepository repository;

    private static Logger logger = LoggerFactory.getLogger(SubsidiaryService.class);

    public GenericResponse CreateSubsidiary(Subsidiary subsidiary){
         repository.save(subsidiary);
         return new GenericResponse("200","La sucursal fue creada con exito");
    }

    public List<SubsidiaryDTO> GetSubsidiaries(){
        List<Subsidiary> subsidiaryList = repository.findAll();
        List<SubsidiaryDTO> subsidiaryDTOList = new ArrayList<>();

        for(Subsidiary item: subsidiaryList){
            SubsidiaryDTO subsidiaryDTO= new SubsidiaryDTO();
            subsidiaryDTO.setId(item.getId());
            subsidiaryDTO.setRuc(item.getRuc());
            subsidiaryDTO.setNombre(item.getNombre());
            subsidiaryDTO.setTipo(item.getTipo());
            subsidiaryDTO.setDireccion(item.getDireccion());
            subsidiaryDTO.setGiroNegocio(item.getGiroNegocio());
            subsidiaryDTO.setPropietario(item.getPropietario());
            subsidiaryDTOList.add(subsidiaryDTO);
        }
        return subsidiaryDTOList;
    }

    public List<GeoDTO> GetGeolocation() {
        logger.info("Inicio obtención listado");
        List<Subsidiary> subsidiaryList = repository.findAll();
        logger.info("finalizar obtención listado");
        List<GeoDTO> geoDTOList = new ArrayList<>();
        for (Subsidiary item : subsidiaryList) {
            GeoDTO geoDTO = new GeoDTO();
            geoDTO.setId(item.getId());
            geoDTO.setRuc(item.getRuc());
            geoDTO.setNombre(item.getNombre());
            geoDTO.setLatitud(Double.parseDouble(item.getLatitud()));
            geoDTO.setLongitud(Double.parseDouble(item.getLongitud()));
            geoDTOList.add(geoDTO);
        }
        return geoDTOList;
    }

    public GenericResponse DeleteSubsidiaryByID(Integer id) {
        repository.deleteById(id);
        return new GenericResponse("100", "La sucursal fue borrada con exito");
    }

    public GenericResponse UpdateSubsidiary(Subsidiary subsidiary) {

        Subsidiary existingSubsidiary = repository.findById(subsidiary.getId()).orElse(null);

        if (existingSubsidiary != null) {
            existingSubsidiary.setRuc(subsidiary.getRuc());
            existingSubsidiary.setNombre(subsidiary.getNombre());
            existingSubsidiary.setTipo(subsidiary.getTipo());
            existingSubsidiary.setDireccion(subsidiary.getDireccion());
            existingSubsidiary.setGiroNegocio(subsidiary.getGiroNegocio());
            existingSubsidiary.setPropietario(subsidiary.getPropietario());

            repository.save(existingSubsidiary);

            return new GenericResponse("200", "La sucursal fue actualizada correctamente");
        } else {
            return new GenericResponse("404", "La sucursal no fue encontrada");
        }
    }

}