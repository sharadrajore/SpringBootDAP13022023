package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.restclient.CouponApi;
import com.zensar.services.ProductService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// @Autowired
	// private RestTemplate restTemplate;

	@Autowired
	private CouponApi couponApi;

	@PostMapping("/")
	@Retry(name = "product-api", fallbackMethod = "handleError")
	// @ResponseBody
	public Product insertProduct(@RequestBody Product product) {

		// Coupon coupon =
		// restTemplate.getForObject("http://localhost:8084/coupons/"+product.getCouponCode(),Coupon.class);

		// Coupon coupon =
		// restTemplate.getForObject("http://COUPON-SERVICE/coupons/"+product.getCouponCode(),Coupon.class);

		Coupon coupon = couponApi.getCoupon(product.getCouponCode());
		System.out.println(coupon);
		System.out.println(product);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productService.insertProduct(product);
	}

	public Product handleError(Product product, Exception e) {
		System.out.println("Inside handleError !!!!");
		return product;
	}

}
