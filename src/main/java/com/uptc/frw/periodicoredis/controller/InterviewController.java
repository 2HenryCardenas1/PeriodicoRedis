package com.uptc.frw.periodicoredis.controller;

import com.uptc.frw.periodicoredis.model.Interview;
import com.uptc.frw.periodicoredis.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("interview")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @GetMapping
    public List<Interview> getAll(){
        return interviewService.findAllInterview();
    }
    @GetMapping("/{id}")
    public Interview getInterview(@PathVariable Long id){
        return interviewService.getInterviewById(id);
    }
    @PostMapping
    public Interview saveInterview(@RequestBody Interview interview){
        return interviewService.saveInterview(interview);
    }
    @PutMapping
    public Interview updateInterview(@RequestBody Interview interview){
        return interviewService.updateInterview(interview);
    }
    @DeleteMapping
    public void deleteInterview(@RequestParam Long id){
        interviewService.deleteInterview(id);
    }
}
