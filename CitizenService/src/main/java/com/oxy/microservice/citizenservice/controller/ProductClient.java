package com.oxy.microservice.citizenservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.oxy.microservice.citizenservice.dto.Product;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/product")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class ProductClient {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Product> list() {		
		List<Product> productList = restTemplate.getForObject("http://PRODUCT-SERVICE/product/list", List.class);
		return productList;
	}

    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    @HystrixCommand(fallbackMethod = "handleProductServiceDownTime")
    public Product showProduct(@PathVariable Integer id){
       Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/product/show/"+id, Product.class);;
        return product;
    }
    
    
    public Product  handleProductServiceDownTime(@PathVariable Integer id) {
    	Product product = new Product();
    	product.setDescription("Default Product");
    	product.setId(5);
    	product.setVersion(2);
        return product;
    }
//
//    @ApiOperation(value = "Add a product")
//    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
//    public ResponseEntity saveProduct(@RequestBody Product product){
//        productService.saveProduct(product);
//        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
//    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product){
//        Product storedProduct = productService.getProductById(id);
//        storedProduct.setDescription(product.getDescription());
//        storedProduct.setImageUrl(product.getImageUrl());
//        storedProduct.setPrice(product.getPrice());
//        productService.saveProduct(storedProduct);
//        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Delete a product")
//    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
//    public ResponseEntity delete(@PathVariable Integer id){
//        productService.deleteProduct(id);
//        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
//
//    }

}