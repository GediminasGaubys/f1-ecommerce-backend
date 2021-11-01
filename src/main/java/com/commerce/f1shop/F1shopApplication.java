package com.commerce.f1shop;

import com.commerce.f1shop.db.ItemRepository;
import com.commerce.f1shop.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@SpringBootApplication
public class F1shopApplication {

	@Autowired
	private ItemRepository repository;

	@PostMapping("/item")
	public Item addItem(@RequestBody Item item) {
		return repository.save(item);
	}

	@GetMapping("/items")
	public List<Item> getItems() {
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(F1shopApplication.class, args);
	}

}
