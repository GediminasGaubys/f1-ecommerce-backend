package com.commerce.f1shop.db;

import com.commerce.f1shop.model.MarkedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkedItemRepository extends JpaRepository<MarkedItem, Long> {
    List<MarkedItem> findByUserId(Long userId);
}
