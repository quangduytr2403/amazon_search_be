package com.example.amazonsearchbe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ProductDto {

    @Id
    private UUID id;

    private String name;

    private String description;

    private BigDecimal originalPrice;

    private BigDecimal salePrice;

    private BrandDto brand;

    private SellerDto seller;

    private String image;

    @JsonProperty("isNew")
    private boolean isNew;

    private BigDecimal rating;

    private int sold;

    private List<CategoryDto> categories;

    @JsonIgnore
    private boolean deleted;
}
