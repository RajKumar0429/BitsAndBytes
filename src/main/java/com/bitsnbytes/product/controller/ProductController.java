package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name= "Product REST API CRUD operation",
        description="Create, Read, Update and Delete operation for products Rest API"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    //create Product
    @Operation(
            summary= "Create Products",
            description = "Rest API to Create Products"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO createProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }
      // Get All Product
    @Operation(
            summary= "Fetch All Products",
            description = "Rest API to Fetch All Products"
    )
    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProducts();
    }

      // Get Product ById
      @Operation(
              summary= "Fetch Products by ProductId",
              description = "Rest API to Fetch Products by ProductId"
      )
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    //update product
    @Operation(
            summary= "Update Product by ProductId",
            description = "Rest API to Update Product by ProductId"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    //Delete product
    @Operation(
            summary= "Delete Product by ProductId",
            description = "Rest API to Delete Product by ProductId"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
//    @DeleteMapping("/{id}")
//    public String deleteProduct(@PathVariable Long id){
//        return productService.deleteProduct(id);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        try {
            String response = productService.deleteProduct(id);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
