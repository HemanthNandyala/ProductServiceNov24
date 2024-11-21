package com.scaler.Product.Service.services;

import com.scaler.Product.Service.DTO.FakeStoreDTO;
import com.scaler.Product.Service.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreApiService implements ProductInterface{
    @Override
    public Product getProductById(long id) {
        String url = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreDTO fakeStoreDTO =  restTemplate.getForObject(url, FakeStoreDTO.class);
        return convertFakeStoreDTOtoProduct(fakeStoreDTO);
    }
    private Product convertFakeStoreDTOtoProduct(FakeStoreDTO dto){
        Product product = new Product();
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getTitle());
        return product;
    }
}