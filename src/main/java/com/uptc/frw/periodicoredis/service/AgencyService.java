package com.uptc.frw.periodicoredis.service;


import com.uptc.frw.periodicoredis.model.Agency;
import com.uptc.frw.periodicoredis.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    @Autowired
    private AgencyRepository agencyRepository;

    public List<Agency> findAllAgency() {
        return agencyRepository.findAll();
    }

    public Agency getAgencyById(Long id) {
        Agency agency = agencyRepository.findById(id).orElse(null);
        return agency;
    }

    public Agency saveAgency(Agency agency){
        Agency newAgency = agencyRepository.save(agency);
        return newAgency;
    }

    public Agency updateAgency(Agency agency){
        Agency agencyNew = getAgencyById(agency.getId());
        if (agencyNew != null){
            agencyNew.setName(agency.getName());
            agencyNew.setCreationYear(agency.getCreationYear());
            saveAgency(agencyNew);
            return agencyNew;
        }else {
            throw new RuntimeException("Registro no Encontrado");
        }
    }

    public void deleteAgency(Long id){
        System.out.println(id);
        agencyRepository.deleteById(id);
    }
}
