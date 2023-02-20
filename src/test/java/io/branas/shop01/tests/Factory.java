package io.branas.shop01.tests;

import java.time.Instant;
import java.util.Set;

import io.branas.shop01.dto.OrderDTO;
import io.branas.shop01.entities.Order;
import io.branas.shop01.entities.Product;

public class Factory {
	
	public static Order createOrder(Set<Product> produtos, String cupom) {
		return new Order(1L, cupom, "69780181202" , Instant.parse("2020-10-20T03:00:00Z"), produtos);
	}
	public static OrderDTO createOrderDTO(Order order) {
		return new OrderDTO(order);
	}
	
	public static Product createProduct() {
		Product product = new Product(1L, "Phone", "Good Phone", 800.0, "https://img.com/img.png",1, Instant.parse("2020-10-20T03:00:00Z"));
		return product;		
	}
	public static Product createProduct1() {
		Product product = new Product(10L, "Clean Code", "Livro de blá blá", 65.0, "https://img.com/img.png",2, Instant.parse("2023-01-20T03:00:00Z"));
		return product;		
	}
	public static Product createProduct2() {
		Product product = new Product(20L, "Design vs. Arquitetura ", "Livro sobre Design vs. Arquitetura", 49.0, "https://img.com/img.png", 1,
				Instant.parse("2023-02-02T03:00:00Z"));
		return product;		
	}
}
