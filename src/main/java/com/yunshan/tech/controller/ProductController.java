package com.yunshan.tech.controller;

import com.yunshan.tech.common.ApiResponse;
import com.yunshan.tech.model.Product;
import com.yunshan.tech.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ApiResponse<List<Product>> list() {
        List<Product> products = productService.selectAll();
        return ApiResponse.success(products);
    }

    @PostMapping("/add")
    public ApiResponse<String> add(@RequestBody Product product) {
        productService.save(product);
        return ApiResponse.success("Product added successfully");
    }

    @PutMapping("/update")
    public ApiResponse<String> update(@RequestBody Product product) {
        productService.updateById(product);
        return ApiResponse.success("Product updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        productService.removeById(id);
        return ApiResponse.success("Product deleted successfully");
    }
}
