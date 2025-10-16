package com.uptc.frw.periodicoredis.controller;

import com.uptc.frw.periodicoredis.model.New;
import com.uptc.frw.periodicoredis.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("new")
public class NewController {
    @Autowired
    private NewService newService;

    @GetMapping
    public List<New> getAll(){
        return newService.findAllNew();
    }
    @GetMapping("/{id}")
    public New getNew(@PathVariable Long id){
        return newService.getNewById(id);
    }
    @PostMapping
    public New saveNew(@RequestBody New anew){
        return newService.saveNew(anew);
    }
    @PutMapping
    public New updateNew(@RequestBody New aNew){
        return newService.updateNew(aNew);
    }
    @DeleteMapping
    public void deleteNew(@RequestParam Long id){
        newService.deleteNew(id);
    }
}
