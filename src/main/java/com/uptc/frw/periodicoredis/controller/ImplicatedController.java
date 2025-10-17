package com.uptc.frw.periodicoredis.controller;

import com.uptc.frw.periodicoredis.model.Implicated;
import com.uptc.frw.periodicoredis.service.ImplicatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("implicated")
public class ImplicatedController {
    @Autowired
    private ImplicatedService implicatedService;

    @GetMapping
    public List<Implicated> getAll(){
        return implicatedService.findAllImplicated();
    }
    @GetMapping("/{id}")
    public Implicated getImplicated(@PathVariable Long id){
        return implicatedService.getImplicatedById(id);
    }
    @PostMapping
    public Implicated saveImplicated(@RequestBody Implicated implicated){
        return implicatedService.saveImplicated(implicated);
    }
    @PutMapping
    public Implicated updateImplicated(@RequestBody Implicated implicated){
        return implicatedService.updateImplicated(implicated);
    }
    @DeleteMapping
    public void deleteImplicated(@RequestParam Long id){
        implicatedService.deleteImplicated(id);
    }
}
