package com.younes.saas.domain.models;

import java.math.BigDecimal;
import java.util.List;

public class Product {

    private String id;
    private String name;
    private String reference;
    private String description;
    private Integer alertThreshold;
    private BigDecimal price;
    private Category category;
    private List<StockMvt> stockMovements;
}
