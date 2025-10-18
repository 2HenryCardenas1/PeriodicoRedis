package com.uptc.frw.periodicoredis.service;

import com.uptc.frw.periodicoredis.model.Interview;
import com.uptc.frw.periodicoredis.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    @Cacheable(value = "interviewByIdCache", key = "'allInterview'")
    public List<Interview> findAllInterview() {
        return interviewRepository.findAll();
    }

    public Interview getInterviewById(Long id) {
        Interview interview = interviewRepository.findById(id).orElse(null);
        return interview;
    }

    public Interview saveInterview(Interview interview){
        Interview newInterview = interviewRepository.save(interview);
        return newInterview;
    }

    public Interview updateInterview(Interview interview){
        Interview interviewNew = getInterviewById(interview.getId());
        if (interviewNew != null){
            saveInterview(interviewNew);
            return interviewNew;
        }else {
            throw new RuntimeException("Registro no Encontrado");
        }
    }
    @CacheEvict(value =  "interviewByIdCache", key = "#id", allEntries = true)
    public void deleteInterview(Long id){
        System.out.println(id);
        interviewRepository.deleteById(id);
    }
}
