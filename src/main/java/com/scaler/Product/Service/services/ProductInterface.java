package com.scaler.Product.Service.services;

import com.scaler.Product.Service.Exception.ProductNotFoundException;
import com.scaler.Product.Service.models.Product;

public interface ProductInterface {
    public Product getProductById(long id)  throws ProductNotFoundException;
}
