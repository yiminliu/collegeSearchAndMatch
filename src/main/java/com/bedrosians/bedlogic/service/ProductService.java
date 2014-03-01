package com.bedrosians.bedlogic.service;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.bedrosians.bedlogic.domain.product.Product;


@Service
public interface ProductService {
	
    public List<? extends Product> getProducts();
	
	public Product getProductById(String id);
	
	public List<Product> getProductByIdPattern(String id);
	
	//public List<? extends Product> getProductsByDescription(String description);
	
	public List<? extends Product> getProductsByVendorId(String id);
		
	public List<? extends Product> getByQueryParameters(MultivaluedMap<String, String> queryParams);
	
	public String createProduct(Product item);
	
	public String createProduct(MultivaluedMap<String, String> queryParams);
	
	public void updateProduct(Product item);
	
	public void updateProduct(String itemId, Product item);
	
	public void updateProduct(MultivaluedMap<String, String> queryParams);

}
