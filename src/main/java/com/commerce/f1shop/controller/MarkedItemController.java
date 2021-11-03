package com.commerce.f1shop.controller;

import com.commerce.f1shop.db.MarkedItemRepository;
import com.commerce.f1shop.exeptions.DoesNotExistException;
import com.commerce.f1shop.model.MarkedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RequestMapping(path = "items/marked")
public class MarkedItemController {

    @Autowired
    private MarkedItemRepository markedItemRepository;

    @GetMapping("/")
    public List<MarkedItem> getMarkedItems() {
        return markedItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<MarkedItem> getMarkedItemsByUserId(@PathVariable Long id){
        return markedItemRepository.findByUserId(id);
    }

    @PostMapping("/")
    public void createMarkedItem(@RequestBody MarkedItem markedItem) throws IOException {
        markedItemRepository.save(markedItem);
    }

    @DeleteMapping(path = { "/{id}" })
    public MarkedItem deleteItem(@PathVariable("id") long id) {
        MarkedItem markedItem = markedItemRepository.findById(id).orElseThrow(() -> new DoesNotExistException(id));
        markedItemRepository.deleteById(id);
        return markedItem;
    }

    @PutMapping("/{id}")
    public MarkedItem updateMarkedItem(@PathVariable("id") long id, @RequestBody MarkedItem newitem) {
        MarkedItem markedItem = markedItemRepository.findById(id).orElseThrow(() -> new DoesNotExistException(id));
        markedItemRepository.deleteById(id);
        newitem.setId(id);
        markedItemRepository.save(newitem);
        return newitem;
    }
}