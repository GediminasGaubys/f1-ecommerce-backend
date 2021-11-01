package com.commerce.f1shop.controller;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

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
//@CrossOrigin(origins = "http://localhost:4200")
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
            Item item = itemRepository.findById(itemId)
                    .orElseThrow(() -> new IOException("Item not found for this id :: " + itemId));
            return ResponseEntity.ok().body(item);
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
        Item item = itemRepository.getOne(id);
        itemRepository.deleteById(id);
        return item;
    }

    @PutMapping("/{id}")
    public void updateItem(@RequestBody Item item) {
        itemRepository.save(item);
    }
}
