package com.uptc.frw.periodicoredis.service;

import com.uptc.frw.periodicoredis.model.New;
import com.uptc.frw.periodicoredis.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewService {
    @Autowired
    private NewRepository newRepository;

    public List<New> findAllNew() {
        return newRepository.findAll();
    }

    public New getNewById(Long id) {
        New aNew = newRepository.findById(id).orElse(null);
        return aNew;
    }

    public New saveNew(New anew){
        New newNew = newRepository.save(anew);
        return newNew;
    }

    public New updateNew(New aNew){
        New newNew = getNewById(aNew.getId());
        if (newNew != null){
            newNew.setDate(aNew.getDate());
            newNew.setHeadline(aNew.getHeadline());
            newNew.setText(aNew.getText());
            saveNew(newNew);
            return newNew;
        }else {
            throw new RuntimeException("Registro no Encontrado");
        }
    }

    public void deleteNew(Long id){
        System.out.println(id);
        newRepository.deleteById(id);
    }
}
