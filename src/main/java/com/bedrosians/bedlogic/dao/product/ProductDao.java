package com.bedrosians.bedlogic.dao.product;

import java.util.List;
import java.util.Set;

import javax.ws.rs.core.MultivaluedMap;

import com.bedrosians.bedlogic.dao.GenericDao;
import com.bedrosians.bedlogic.domain.product.Product;


public interface ProductDao extends GenericDao<Product, String>{
  
  public Product getProductById(String itemId);  
  public List<? extends Product> getAllProducts();  
  public List<Product> getProductsByQueryParameters(MultivaluedMap<String, String> queryParams);
  
  public List<? extends Product> getProductsByIdPatternMatch(String Id);
  //public List<? extends Product> getProductsByDiscriptionPatternMatch(String description);
 // public List<SimplifiedProduct> getProductByStatus(String status);
  //public String createProduct(SimplifiedProduct symolifiedProduct);
  public void updateProduct(Product product);
  public String createProduct(Product product);
    
}