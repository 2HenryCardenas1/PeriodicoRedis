package com.uptc.frw.periodicoredis.service;

import com.uptc.frw.periodicoredis.model.AgNew;
import com.uptc.frw.periodicoredis.repository.AgNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgNewService {
    @Autowired
    private AgNewRepository agNewRepository;

    public List<AgNew> findAllAgNew() {
        return agNewRepository.findAll();
    }

    public AgNew getAgNewById(Long id) {
        AgNew agNew = agNewRepository.findById(id).orElse(null);
        return agNew;
    }

    public AgNew saveAgNew(AgNew agNew){
        AgNew newAgNew = agNewRepository.save(agNew);
        return newAgNew;
    }

    public AgNew updateAgNew(AgNew agNew){
        AgNew agNewNew = getAgNewById(agNew.getId());
        if (agNewNew != null){
            agNewNew.setHourNew(agNew.getHourNew());
            saveAgNew(agNewNew);
            return agNewNew;
        }else {
            throw new RuntimeException("Registro no Encontrado");
        }
    }

    public void deleteAgNew(Long id){
        System.out.println(id);
        agNewRepository.deleteById(id);
    }
}
