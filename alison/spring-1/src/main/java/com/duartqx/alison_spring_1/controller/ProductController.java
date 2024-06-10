package com.duartqx.alison_spring_1.controller;

import com.duartqx.alison_spring_1.dto.NamesIn;
import com.duartqx.alison_spring_1.dto.ProductDTO;
import com.duartqx.alison_spring_1.entity.Product;
import com.duartqx.alison_spring_1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/findByName", method = RequestMethod.POST)
    public List<Product> findByName(@RequestBody NamesIn namesIn) {
        return productService.findByNameIn(namesIn.names());
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Product create(@RequestBody ProductDTO productDTO) {
        Product product = new Product(
            productDTO.name(),
            productDTO.category(),
            productDTO.type(),
            productDTO.sector()
        );
        return productService.create(product);
    }
}
