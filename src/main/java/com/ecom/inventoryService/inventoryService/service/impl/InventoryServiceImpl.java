package com.ecom.inventoryService.inventoryService.service.impl;

import com.ecom.inventoryService.inventoryService.exceptionHandling.customException.ProductAlreadyExistsException;
import com.ecom.inventoryService.inventoryService.exceptionHandling.customException.ProductDoesNotExistException;
import com.ecom.inventoryService.inventoryService.model.Inventory;
import com.ecom.inventoryService.inventoryService.repository.InventoryRepository;
import com.ecom.inventoryService.inventoryService.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;

    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryByProductId(String productId) {
        return inventoryRepository.findByProductId(productId);
    }

    public Inventory updateInventory(Inventory request) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findByProductId(request.getProductId());
            if(inventoryOptional.isPresent()){
                Inventory inventory = inventoryOptional.get();
                inventory.setAvailableStock(request.getAvailableStock());
                return inventoryRepository.save(inventory);
            }else {
                throw new ProductDoesNotExistException("Product does not exist.");
            }

    }

    public Inventory addInventory(Inventory request){

        if(inventoryRepository.findByProductId(request.getProductId()).isPresent()){
            throw new ProductAlreadyExistsException("Product already exists.");
        }else{
            Inventory inventory = Inventory.builder()
                    .productId(request.getProductId())
                    .availableStock(request.getAvailableStock())
                    .build();
            return inventoryRepository.save(inventory);
        }
    }
}
