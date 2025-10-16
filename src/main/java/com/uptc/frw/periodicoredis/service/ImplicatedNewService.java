package com.uptc.frw.periodicoredis.service;

import com.uptc.frw.periodicoredis.model.ImplicatedNew;
import com.uptc.frw.periodicoredis.repository.ImplicatedNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplicatedNewService {
    @Autowired
    private ImplicatedNewRepository implicatedNewRepository;

    public List<ImplicatedNew> findAllImplicatedNew() {
        return implicatedNewRepository.findAll();
    }

    public ImplicatedNew getImplicatedNewById(Long id) {
        ImplicatedNew implicatedNew = implicatedNewRepository.findById(id).orElse(null);
        return implicatedNew;
    }

    public ImplicatedNew saveImplicatedNew(ImplicatedNew implicatedNew){
        ImplicatedNew newImplicatedNew = implicatedNewRepository.save(implicatedNew);
        return newImplicatedNew;
    }

    public ImplicatedNew updateImplicatedNew(ImplicatedNew implicatedNew){
        ImplicatedNew implicatedNewNew = getImplicatedNewById(implicatedNew.getId());
        if (implicatedNewNew != null){
            implicatedNewNew.setRol(implicatedNewNew.getRol());
            saveImplicatedNew(implicatedNewNew);
            return implicatedNewNew;
        }else {
            throw new RuntimeException("Registro no Encontrado");
        }
    }

    public void deleteImplicatedNew(Long id){
        System.out.println(id);
        implicatedNewRepository.deleteById(id);
    }
}
