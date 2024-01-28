package com.example.amazonsearchbe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pagination<T> {
    @JsonProperty("total")
    private long total;
    @JsonProperty("page")
    private int page;
    @JsonProperty("size")
    private int size;
    @JsonProperty("items")
    private List<T> items;

    public Pagination(List<T> items, int page, int size, long total) {
        if (page < 0) {
            throw new IllegalArgumentException("The page number must not be less than 0.");
        }
        if (size < 1) {
            throw new IllegalArgumentException("The page size must not be less than 1.");
        }
        this.total = total;
        this.items = items;
        this.page = page;
        this.size = size;
    }

    public static <T> Pagination<T> create(List<T> items, int page, int size, long total) {
        return new Pagination<>(items, page, size, total);
    }

    public long total() {
        return total;
    }

    public int totalPages() {
        return (int) Math.ceil((double) total / (double) size);
    }

    public int page() {
        return page;
    }

    public int size() {
        return size;
    }

    public List<T> items() {
        return items == null ? Collections.emptyList() : items;
    }

    public boolean hasNext() {
        return (page + 1 <= totalPages());
    }
}
