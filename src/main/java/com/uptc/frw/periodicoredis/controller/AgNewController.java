package com.uptc.frw.periodicoredis.controller;

import com.uptc.frw.periodicoredis.model.AgNew;
import com.uptc.frw.periodicoredis.service.AgNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agNew")
public class AgNewController {
    @Autowired
    private AgNewService agNewService;

    @GetMapping
    public List<AgNew> getAll(){
        return agNewService.findAllAgNew();
    }
    @GetMapping("/{id}")
    public AgNew getAgNew(@PathVariable Long id){
        return agNewService.getAgNewById(id);
    }
    @PostMapping
    public AgNew saveAgNew(@RequestBody AgNew agNew){
        return agNewService.saveAgNew(agNew);
    }
    @PutMapping
    public AgNew updateAgNew(@RequestBody AgNew agNew){
        return agNewService.updateAgNew(agNew);
    }
    @DeleteMapping
    public void deleteAgNew(@RequestParam Long id){
        agNewService.deleteAgNew(id);
    }
}
