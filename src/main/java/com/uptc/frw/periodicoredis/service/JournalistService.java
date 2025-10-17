package com.uptc.frw.periodicoredis.service;

import com.uptc.frw.periodicoredis.model.Journalist;
import com.uptc.frw.periodicoredis.repository.JournalistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JournalistService {
    @Autowired
    private JournalistRepository journalistRepository;

    public List<Journalist> findAllJournalist() {
        return journalistRepository.findAll();
    }

    public Journalist getJournalisById(Long id) {
        Journalist journalist = journalistRepository.findById(id).orElse(null);
        return journalist;
    }

    public Journalist saveJournalist(Journalist journalist){
        Journalist newJournalist = journalistRepository.save(journalist);
        return newJournalist;
    }

    public Journalist updateJournalist(Journalist journalist){
        Journalist journalistNew = getJournalisById(journalist.getId());
        if (journalistNew != null){
            journalistNew.setName(journalist.getName());
            journalistNew.setAddress(journalist.getAddress());
            journalistNew.setPhone(journalist.getPhone());
            journalistNew.setNumNew(journalist.getNumNew());
            saveJournalist(journalistNew);
            return journalistNew;
        }else {
            throw new RuntimeException("Registro no Encontrado");
        }
    }

    public void deleteJournalist(Long id){
        System.out.println(id);
        journalistRepository.deleteById(id);
    }
}
