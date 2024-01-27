package com.example.amazonsearchbe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SellerDto {

    private UUID id;

    private String name;

    private String logo;

    private String description;

    private long createdAt;

    private long updatedAt;

    @JsonIgnore
    private boolean deleted;
}
