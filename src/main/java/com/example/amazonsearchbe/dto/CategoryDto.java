package com.example.amazonsearchbe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CategoryDto {

    private UUID id;

    private String name;

    private UUID parentId;

    private boolean hasChildren;

    private long createdAt;

    private long updatedAt;

    @JsonIgnore
    private boolean deleted;
}
