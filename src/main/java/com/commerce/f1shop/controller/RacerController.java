package com.commerce.f1shop.controller;

import com.commerce.f1shop.db.RacerRepository;
import com.commerce.f1shop.exeptions.DoesNotExistException;
import com.commerce.f1shop.model.Racer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RequestMapping(path = "racers")
public class RacerController {

    @Autowired
    private RacerRepository racerRepository;

    @GetMapping("/")
    public List<Racer> getRacers() {
        return racerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Racer> getRacerById(@PathVariable(value = "id") Long racerId) throws IOException {
        Racer racer = racerRepository.findById(racerId).orElseThrow(() -> new DoesNotExistException(racerId));
        return ResponseEntity.ok().body(racer);
    }

    @PostMapping("/")
    public void createRacer(@RequestBody Racer racer) throws IOException {
        racerRepository.save(racer);
    }

    @DeleteMapping(path = { "/{id}" })
    public Racer deleteRacer(@PathVariable("id") long id) {
        Racer racer = racerRepository.findById(id).orElseThrow(() -> new DoesNotExistException(id));
        racerRepository.deleteById(id);
        return racer;
    }

//    @PutMapping("/{id}")
//    public Racer updateRacer(@PathVariable("id") long id, @RequestBody Racer newRacer) {
//        Racer racer = racerRepository.findById(id).orElseThrow(() -> new DoesNotExistException(id));
//        racerRepository.deleteById(id);
//        newRacer.setId(id);
//        racerRepository.save(newRacer);
//        return newRacer;
//    }

    @PutMapping("/")
    public void updateRacer(@RequestBody Racer racer) {
        racerRepository.save(racer);
    }
}