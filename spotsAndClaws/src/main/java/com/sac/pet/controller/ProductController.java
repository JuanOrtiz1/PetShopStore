package com.sac.pet.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sac.pet.model.Product;
import com.sac.pet.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/crearProveedor")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    
    @PutMapping("/modificarProveedor/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }
    
    @PutMapping("/modificarEstadoProveedor/{id}")
    public String changeProductStatus(@PathVariable Long id, @RequestBody Product product) {
        return productService.changeProductStatus(id, product);
    }
    
    @GetMapping("/buscarPorId/{product}")
    public boolean getProductById(@PathVariable Long product) {
        return productService.existProduct(product);
    }
    
    @GetMapping("/buscarPorNombre/{description}")
    public Product getProductByName(@PathVariable String description) {
        return productService.findProductByName(description);
    }
    
    @DeleteMapping("eliminarProveedor/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        try {
            productService.deleteProductById(id);
            return ResponseEntity.ok().body("Se ha eliminado con éxito");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
