package com.nexsy.dto;

public class ProductIdResponse {
    private Long pid;

    public ProductIdResponse(Long pid) {
        this.pid = pid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
