package com.ecom.inventoryService.inventoryService.service;

import com.ecom.inventoryService.inventoryService.model.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InventoryService {

    List<Inventory> getInventory();
    Optional<Inventory> getInventoryByProductId(String productId);
    Inventory updateInventory(Inventory inventory);
    Inventory addInventory(Inventory inventory);
}
