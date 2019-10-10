package com.yao.vuedemo;

import lombok.Data;

@Data
public class ResultBean {
    private Object info;
    private Integer totalSize;
    private Integer totalPageSize;
    private String code="0";
    private boolean status=true;

    public ResultBean() {
    }

    public ResultBean(Object info) {
        this.info = info;
    }

    public ResultBean(Object info, Integer totalSize, Integer totalPageSize) {
        this.info = info;
        this.totalSize = totalSize;
        this.totalPageSize = totalPageSize;
    }
}
