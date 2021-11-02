package com.commerce.f1shop.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.f1shop.model.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>{

    List<Item> findByRacerId(Long racerId);
}
