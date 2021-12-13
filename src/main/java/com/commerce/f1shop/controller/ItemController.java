package com.commerce.f1shop.controller;

import java.io.IOException;
import java.util.List;

import com.commerce.f1shop.exeptions.DoesNotExistException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.commerce.f1shop.db.ItemRepository;
import com.commerce.f1shop.model.Item;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RequestMapping(path = "items")
public class ItemController {

    private byte[] bytes;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Long itemId) throws IOException {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new DoesNotExistException(itemId));
        return ResponseEntity.ok().body(item);
    }

    @GetMapping("/racer/{id}")
    public List<Item> getItemsByRacerId(@PathVariable Long id){
        return itemRepository.findByRacerId(id);
    }

    @PostMapping("/image")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }

    @PostMapping("/")
    public void createItem(@RequestBody Item item) throws IOException {
        item.setPicByte(this.bytes);
        itemRepository.save(item);
        this.bytes = null;
    }

    @DeleteMapping(path = { "/{id}" })
    public Item deleteItem(@PathVariable("id") long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new DoesNotExistException(id));
        itemRepository.deleteById(id);
        return item;
    }

//    @PutMapping("/{id}")
//    public Item updateItem(@PathVariable("id") long id, @RequestBody Item newitem) {
//        Item item = itemRepository.findById(id).orElseThrow(() -> new DoesNotExistException(id));
//        itemRepository.deleteById(id);
//        newitem.setId(id);
//        itemRepository.save(newitem);
//        return newitem;
//    }

    @PutMapping("/")
    public void updateItem(@RequestBody Item item) {
        itemRepository.save(item);
    }
}
