package com.example.amazonsearchbe.model;

import lombok.Getter;

@Getter
public final class SuccessResponse<T> {
    private final boolean success;
    private final T data;

    public SuccessResponse() {
        this.success = true;
        this.data = null;
    }

    public SuccessResponse(T data) {
        this.success = true;
        this.data = data;
    }

}
