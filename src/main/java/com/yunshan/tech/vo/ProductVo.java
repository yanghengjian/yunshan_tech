package com.yunshan.tech.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

@Data
public class ProductVo {
    private String name;

    private String specification;

    private String condition;

    private Integer minPrice;

    private Integer maxPrice;

    private String contact;

    private Integer isShow;
}
