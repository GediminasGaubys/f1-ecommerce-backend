package com.commerce.f1shop.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.f1shop.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
}
