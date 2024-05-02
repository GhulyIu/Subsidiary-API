package com.pichincha.SubsidiaryAPI.Controller;

import com.pichincha.SubsidiaryAPI.DTO.GenericResponse;
import com.pichincha.SubsidiaryAPI.DTO.GeoDTO;
import com.pichincha.SubsidiaryAPI.DTO.SubsidiaryDTO;
import com.pichincha.SubsidiaryAPI.Model.Subsidiary;
import com.pichincha.SubsidiaryAPI.Service.SubsidiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SubsidiaryController {

    @Autowired
    private SubsidiaryService service;

    @PostMapping("/CreateSubsidiary")
    public GenericResponse createSubsidiary(@RequestBody Subsidiary subsidiary) {
        return service.CreateSubsidiary(subsidiary);
    }
    @GetMapping("/GetSubsidiaries")
    public List<SubsidiaryDTO> GetAllSubsidiary() {
        return service.GetSubsidiaries();
    }
    @DeleteMapping("/DeleteSubsidiary")
    public GenericResponse DeleteSubsidiaryByID(Integer id) {
        return service.DeleteSubsidiaryByID(id);
    }
    @PutMapping("/UpdateSubsidiary")
    public GenericResponse UpdateSubsidiary(@RequestBody Subsidiary subsidiary) {
        return service.UpdateSubsidiary(subsidiary);
    }
    //hola
    @GetMapping("/GetGeolocation")
    public List<GeoDTO> GetGeolocation() {
        return service.GetGeolocation();}
}
