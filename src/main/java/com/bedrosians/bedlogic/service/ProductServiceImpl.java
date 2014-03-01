package com.bedrosians.bedlogic.service;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.dao.product.ProductDao;
import com.bedrosians.bedlogic.domain.product.Product;
import com.bedrosians.bedlogic.exeception.DataNotFoundException;
import com.bedrosians.bedlogic.util.PatternMatchMode;
import com.bedrosians.bedlogic.util.ProductUtil;
import com.bedrosians.bedlogic.util.logger.aspect.LogLevel;
import com.bedrosians.bedlogic.util.logger.aspect.Loggable;


@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
	ProductDao productDao;    
 
    	    	
    @Loggable(value = LogLevel.TRACE)
    @Override
	@Transactional(readOnly=true)
	public Product getProductById(String id) {
    	return productDao.getProductById(id);
		//if(product != null){	         		
		//	product.setCheckPayments(checkPaymentDao.getCheckPaymentsForProduct(id));
		//}
	}

    @Loggable(value = LogLevel.TRACE)
    @Override
	@Transactional(readOnly=true)
	public List<Product> getProductByIdPattern(String id) {
    	return null;
	}
    
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Product> getProducts(){
		return productDao.findAll();
	}
    
   // @Loggable(value = LogLevel.TRACE)
	//@Override
	//@Transactional(readOnly=true)
    //public List<Product> getProductsByDescription(String description){
    //	return (List<Product>)productDao.getProductsByDiscriptionPatternMatch(description);
    //}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Product> getProductsByVendorId(String id){
    	return null;
    }
	
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Product> getByQueryParameters(MultivaluedMap<String, String> queryParams){
		return productDao.findByParameters(queryParams);
	}
		
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public String createProduct(Product product){
		return productDao.createProduct(product); 
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public String createProduct(MultivaluedMap<String, String> queryParams){
		return productDao.createProduct(ProductUtil.buildProduct(queryParams));
	}
	
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public void updateProduct(String productId, Product product){
		Product retrievedProduct = null;
		try{
		   retrievedProduct = getProductById(productId);
		   if(retrievedProduct == null)
			  throw new DataNotFoundException("No data found"); 
		}
		catch(Exception e){
			throw e;
			
		}
		//if(product instanceof ProductDetail)
		   productDao.updateProduct((Product)product); 
		//else if(product instanceof SimplifiedProduct)
		  // productDao.update((SimplifiedProduct)product); 
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public void updateProduct(Product product){
		productDao.updateProduct(product); 
	}	
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public void updateProduct(MultivaluedMap<String, String> queryParams){
		productDao.updateProduct(ProductUtil.buildProduct(queryParams));
	}
	
}
