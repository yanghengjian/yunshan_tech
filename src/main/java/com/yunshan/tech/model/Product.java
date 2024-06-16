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

    @ElementCollection
    private List<String> images;

    private String specification;

    private String description;

    @Column(name = "product_condition")
    private String condition;

    private Double price;

    private String contact;

    // Getters and Setters
}

