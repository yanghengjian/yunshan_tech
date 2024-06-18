package com.yunshan.tech.controller;

import com.yunshan.tech.common.ApiResponse;
import com.yunshan.tech.model.Product;
import com.yunshan.tech.service.ProductService;
import com.yunshan.tech.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping ("/list")
    public ApiResponse<List<Product>> list(@RequestBody ProductVo productVo) {
        List<Product> products = productService.selectList(productVo);
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

    @GetMapping ("/getId/{id}")
    public ApiResponse<Product> getId(@PathVariable Long id) {
        Product byId = productService.getById(id);
        return ApiResponse.success(byId);
    }

    @GetMapping("/updateIsShow")
    public ApiResponse<Boolean> updateIsShow(@RequestParam Long id,@RequestParam Integer isShow) {
        Product product = new Product();
        product.setIsShow(isShow);
        product.setId(id);

        return ApiResponse.success(productService.updateById(product));
    }
}
