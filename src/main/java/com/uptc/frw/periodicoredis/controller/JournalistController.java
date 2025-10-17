package com.uptc.frw.periodicoredis.controller;

import com.uptc.frw.periodicoredis.model.Journalist;
import com.uptc.frw.periodicoredis.service.JournalistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("journalist")
public class JournalistController {
    @Autowired
    private JournalistService journalistService;

    @GetMapping
    public List<Journalist> getAll(){
        return journalistService.findAllJournalist();
    }
    @GetMapping("/{id}")
    public Journalist getJournalist(@PathVariable Long id){
        return journalistService.getJournalisById(id);
    }
    @PostMapping
    public Journalist saveJournalist(@RequestBody Journalist journalist){
        return journalistService.saveJournalist(journalist);
    }
    @PutMapping
    public Journalist updateJournalist(@RequestBody Journalist journalist){
        return journalistService.updateJournalist(journalist);
    }
    @DeleteMapping
    public void deleteJournalist(@RequestParam Long id){
        journalistService.deleteJournalist(id);
    }
}
