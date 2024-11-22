package com.scaler.Product.Service.Controller;

import com.scaler.Product.Service.Exception.ProductNotFoundException;
import com.scaler.Product.Service.models.Product;
import com.scaler.Product.Service.services.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductInterface productInterface;
    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
//        if(id < 1 || id > 20){
//            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
//        }
        Product product = productInterface.getProductById(id);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200) );
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> getProductNotFoundException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatusCode.valueOf(400));

    }
}
