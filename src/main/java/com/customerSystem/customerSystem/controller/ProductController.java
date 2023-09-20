package com.customersystem.customersystem.controller;

import com.customersystem.customersystem.mapper.ProductMapper;
import com.customersystem.customersystem.model.Product;
import com.customersystem.customersystem.modeldto.ProductDto;
import com.customersystem.customersystem.modeldto.StatusMessageDto;
import com.customersystem.customersystem.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private ProductService productService;
    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        StatusMessageDto<List<ProductDto>> responseMsg = new StatusMessageDto<List<ProductDto>>();
         try{
             List<Product> products = productService.findAll();
             List<ProductDto> productDtos = new ArrayList<ProductDto>();
             for (Product item:products) {
                 productDtos.add(productMapper.toDto(item));
             }

             responseMsg.setStatus(HttpStatus.OK.value());
             responseMsg.setMessage("Products shown successfully");
             responseMsg.setData(productDtos);

             return ResponseEntity.ok().body(responseMsg);
         } catch(Exception e) {
             responseMsg.setMessage("Product shown failed");

             return ResponseEntity.badRequest().body(responseMsg);
         }

    }

    // to find products owned by a customer
    @PostMapping("findProduct")
    public ResponseEntity<?> findByCustomerCin(@RequestParam long cin) {
        StatusMessageDto<List<ProductDto>> responseMsg = new StatusMessageDto<List<ProductDto>>();

        try{
            List<Product> products = productService.findByCin(cin);
            List<ProductDto> productDtos = new ArrayList<ProductDto>();

            for(Product item:products) {
                productDtos.add(productMapper.toDto(item));
            }

            if(productDtos.size() > 0) {
                responseMsg.setMessage("Found");
                responseMsg.setStatus(HttpStatus.OK.value());
                responseMsg.setData(productDtos);
                return ResponseEntity.ok().body(responseMsg);
            } else {
                responseMsg.setMessage("Not Found");
                responseMsg.setStatus(HttpStatus.BAD_REQUEST.value());
//                responseMsg.setData(productDtos);
                return ResponseEntity.badRequest().body(responseMsg);
            }
        } catch(Exception e) {
            responseMsg.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(responseMsg);
        }
    }

    @PostMapping("addProduct")
    public ResponseEntity<?> addProduct(@RequestParam Long cin, @RequestParam Long product_id, @RequestParam Long account_id) {
        StatusMessageDto<ProductDto> responseMsg = new StatusMessageDto<ProductDto>();

        try {
            Product product = productService.addProduct(cin, product_id, account_id);
            ProductDto productDto = productMapper.toDto(product);

            if(productDto != null) {
                responseMsg.setStatus(HttpStatus.OK.value());
                responseMsg.setMessage("Product created");
                responseMsg.setData(productDto);

                return ResponseEntity.ok().body(responseMsg);
            } else {
                responseMsg.setStatus(HttpStatus.BAD_REQUEST.value());
                responseMsg.setMessage("Failed");

                return ResponseEntity.badRequest().body(responseMsg);
            }
        } catch(Exception e) {
            responseMsg.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(responseMsg);
        }
    }

    @PostMapping("closeProduct")
    public ResponseEntity<?> closeProduct(@RequestParam Long account_id, @RequestParam Long product_id) {
        StatusMessageDto<ProductDto> responseMsg = new StatusMessageDto<ProductDto>();

        try {
            Product product = productService.closeProduct(account_id, product_id);
            ProductDto productDto = productMapper.toDto(product);

            if(productDto != null) {
                responseMsg.setStatus(HttpStatus.OK.value());
                responseMsg.setMessage("Product closed");
                responseMsg.setData(productDto);

                return ResponseEntity.ok().body(responseMsg);
            } else {
                responseMsg.setStatus(HttpStatus.BAD_REQUEST.value());
                responseMsg.setMessage("Failed");

                return ResponseEntity.badRequest().body(responseMsg);
            }
        } catch(Exception e) {
            responseMsg.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(responseMsg);
        }
    }

}
