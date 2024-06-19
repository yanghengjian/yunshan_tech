package com.yunshan.tech.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@TableName("Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String  images;

    private String specification;

    private String description;

    @Column(name = "product_condition")
    private String productCondition;

    private Double price;

    private String contact;

    @Column(name = "is_show")
    private Integer isShow;

    // Getters and Setters
}

