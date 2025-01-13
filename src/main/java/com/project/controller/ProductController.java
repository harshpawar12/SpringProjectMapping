package com.project.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.IdnotFoundException;
import com.project.Services.ProductService;
import com.project.model.ProductDTO;
import com.project.model.ProductModel;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    
    /*
     Getting All the product_Data and in there 
     	i used the pegination to set the piece of
     		pages.
     */
    @GetMapping("/api/products")
    public List<ProductDTO> isGetAllProducts(@RequestParam (defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "5") int size) {
        List<ProductModel> products = productService.isGetAllProducts(page, size);
        return products.stream()
                       .map(ProductDTO::new)
                       .collect(Collectors.toList());
    }
    
    @PostMapping("/api/products")
    public ProductModel createProduct(@RequestBody ProductModel product) {
       return productService.createProduct(product);
   }

    @GetMapping("/api/products/{id}")
    public ProductModel isGetById(@PathVariable int id) throws IdnotFoundException
    {
    	return productService.isGettingByid(id);
    }
    
    @PutMapping("/api/products/{id}")
    public ProductModel isUpdateProduct(@PathVariable long id,@RequestBody ProductModel ob) throws IdnotFoundException
    {
    	return productService.isUpdatingProduct(id,ob);
    }
    
    @DeleteMapping("/api/products/{id}")
    public String isDeletedbyid(@PathVariable long id) throws IdnotFoundException
    {
    	return productService.isdeletedbyId(id);
    }
    
    

   
}


