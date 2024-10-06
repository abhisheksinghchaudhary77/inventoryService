package com.ecom.inventoryService.inventoryService.controller;


import com.ecom.inventoryService.inventoryService.model.Inventory;
import com.ecom.inventoryService.inventoryService.service.InventoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
@AllArgsConstructor
@Slf4j
public class InventoryController {

    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<Inventory>> getInventory() {
        List<Inventory> inventory = inventoryService.getInventory();
        if (!inventory.isEmpty()) {
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventorybyProductId(@PathVariable String productId) {
        Optional<Inventory> inventory = inventoryService.getInventoryByProductId(productId);
        if (inventory.isPresent()) {
            return new ResponseEntity<>(inventory.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory request) {
        Inventory response = inventoryService.updateInventory(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        Inventory response = inventoryService.addInventory(inventory);
        log.info("Id generated: {}", response.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
