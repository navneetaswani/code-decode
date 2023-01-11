package com.oxy.microservice.vaccinationcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.oxy.microservice.vaccinationcenter.Model.Product;

import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/product")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class ProductClient {

	@Autowired
	WebClient webClient;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Product> list() {		
//		List<Product> productList
		Flux<Product>  emplist= 
				webClient.get().uri("/list").retrieve().bodyToFlux(Product.class);
				

//		Iterable<Product> productList = productService.listAllProducts();
		return emplist.collectList().block();
	}
	
	


//    @ApiOperation(value = "Search a product with an ID",response = Product.class)
//    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
//    public Product showProduct(@PathVariable Integer id, Model model){
//       Product product = productService.getProductById(id);
//        return product;
//    }
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