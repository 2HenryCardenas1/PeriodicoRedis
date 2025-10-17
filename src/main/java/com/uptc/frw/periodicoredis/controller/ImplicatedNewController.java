package com.uptc.frw.periodicoredis.controller;

import com.uptc.frw.periodicoredis.model.ImplicatedNew;
import com.uptc.frw.periodicoredis.service.ImplicatedNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("implicatedNew")
public class ImplicatedNewController {
    @Autowired
    private ImplicatedNewService implicatedNewService;

    @GetMapping
    public List<ImplicatedNew> getAll(){
        return implicatedNewService.findAllImplicatedNew();
    }
    @GetMapping("/{id}")
    public ImplicatedNew getImplicatedNew(@PathVariable Long id){
        return implicatedNewService.getImplicatedNewById(id);
    }
    @PostMapping
    public ImplicatedNew saveImplicatedNew(@RequestBody ImplicatedNew implicatedNew){
        return implicatedNewService.saveImplicatedNew(implicatedNew);
    }
    @PutMapping
    public ImplicatedNew updateImplicatedNew(@RequestBody ImplicatedNew implicatedNew){
        return implicatedNewService.updateImplicatedNew(implicatedNew);
    }
    @DeleteMapping
    public void deleteImplicatedNew(@RequestParam Long id){
        implicatedNewService.deleteImplicatedNew(id);
    }
}
