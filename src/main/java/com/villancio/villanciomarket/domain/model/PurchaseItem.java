package com.villancio.villanciomarket.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurchaseItem {
    private Integer productId;
    private Integer quantity;
    private double total;
    private boolean active;

}
