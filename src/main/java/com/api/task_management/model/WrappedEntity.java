package com.api.task_management.model;

import lombok.Getter;

@Getter
public class WrappedEntity<T> extends ApiResult {
    private final T data;

    public WrappedEntity(T data) {
        super(ResponseStatus.SUCCESS);
        this.data = data;
    }
}
