package com.uptc.frw.periodicoredis.controller;

import com.uptc.frw.periodicoredis.model.Agency;
import com.uptc.frw.periodicoredis.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agency")
public class AgencyController {
    @Autowired
    private AgencyService agencyService;

    @GetMapping
    public List<Agency> getAll(){
        return agencyService.findAllAgency();
    }
    @GetMapping("/{id}")
    public Agency getAgency(@PathVariable Long id){
        return agencyService.getAgencyById(id);
    }
    @PostMapping
    public Agency saveAgency(@RequestBody Agency agency){
        return agencyService.saveAgency(agency);
    }
    @PutMapping
    public Agency updateAgency(@RequestBody Agency agency){
        return agencyService.updateAgency(agency);
    }
    @DeleteMapping
    public void deleteAgency(@RequestParam Long id){
        agencyService.deleteAgency(id);
    }
}
