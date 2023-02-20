package io.branas.shop01.dto;

import java.io.Serializable;
import java.util.Set;

import io.branas.shop01.entities.Order;
import io.branas.shop01.entities.Product;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cpf;
	private Set<Product> products;
	private Double total;
	private String cupom;
	
	public OrderDTO() {	}
	public OrderDTO(Long id, String cpf, Set<Product> products,Double total, String cupom ) {
		this.id = id;
		this.cpf = cpf;
		this.products = products;
		this.total = total;
		this.cupom = cupom;
	}
	public OrderDTO(Order order) {
		this.id = order.getId();
		this.cpf = order.getCpf();
		this.products = order.getProducts();
		this.total = order.getTotal();
		this.cupom = order.getCupom();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getCupom() {
		return cupom;
	}
	public void setCupom(String cupom) {
		this.cupom = cupom;
	}
	


}
