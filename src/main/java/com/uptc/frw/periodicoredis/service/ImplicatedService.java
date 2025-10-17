package com.uptc.frw.periodicoredis.service;

import com.uptc.frw.periodicoredis.model.Implicated;
import com.uptc.frw.periodicoredis.repository.ImplicatedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplicatedService {
    @Autowired
    private ImplicatedRepository implicatedRepository;

    public List<Implicated> findAllImplicated() {
        return implicatedRepository.findAll();
    }

    public Implicated getImplicatedById(Long id) {
        Implicated implicated = implicatedRepository.findById(id).orElse(null);
        return implicated;
    }

    public Implicated saveImplicated(Implicated implicated){
        Implicated newImplicated = implicatedRepository.save(implicated);
        return newImplicated;
    }

    public Implicated updateImplicated(Implicated implicated){
        Implicated implicatedNew = getImplicatedById(implicated.getId());
        if (implicatedNew != null){
            implicatedNew.setName(implicated.getName());
            implicatedNew.setBirthDay(implicated.getBirthDay());
            saveImplicated(implicatedNew);
            return implicatedNew;
        }else {
            throw new RuntimeException("Registro no Encontrado");
        }
    }

    public void deleteImplicated(Long id){
        System.out.println(id);
        implicatedRepository.deleteById(id);
    }
}
