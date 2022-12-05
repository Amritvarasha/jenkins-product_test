package com.product.service.productservice.controller;

import com.product.service.productservice.dto.ProductRequest;
import com.product.service.productservice.dto.ProductResponse;
import com.product.service.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
//@RequestMapping("/api/product")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;
  @PostConstruct
    public void init(){
      log.info("Application Started");
  }

    @GetMapping("/hello")
    public String getDetails(){
        return "Hello ";
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }


}
