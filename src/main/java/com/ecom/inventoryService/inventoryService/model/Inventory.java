package com.ecom.inventoryService.inventoryService.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Document(collection = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
@Builder
public class Inventory {

    @Id
    private String id;  //mongo's internal ID

    @NotBlank(message = "Product ID required.")
    private String productId;
    private int availableStock;

    @LastModifiedDate
    private LocalDateTime lastUpdated;

}
