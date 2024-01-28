package com.example.amazonsearchbe.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductES {

    private UUID id;

    private String name;

    private String description;

    private BigDecimal originalPrice;

    private BigDecimal salePrice;

    private UUID brandId;

    private UUID sellerId;

    private String image;

    private boolean newProduct;

    private BigDecimal rating;

    private int sold;

    private boolean deleted;
}
