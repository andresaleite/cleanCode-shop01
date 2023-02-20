package io.branas.shop01.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cupom;
	private String cpf;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_order_product",
		joinColumns = @JoinColumn(name = "order_id"),
		inverseJoinColumns = @JoinColumn(name = "product_id"))	
	private Set<Product> products = new HashSet<Product>();
	
	public Order() {}
	public Order(Long id, String cupom, String cpf, Instant date, Set<Product> products) {
		this.id = id;
		this.cupom = cupom;
		this.cpf = cpf;
		this.date = date;
		this.products = products;
	}

	public Double getTotal() {
		
		if(this.products == null || this.products.isEmpty()) {
			return 0.0;
		}
		return calculaTotal(this.products);
	}

	private Double calculaTotal(Set<Product> products2) {
		Double total = 0.0;
		Double desconto = validaCupom();
		for(Product produto: this.getProducts()) {
			total += produto.getPrice() * produto.getQuantity();
		}
		if(desconto > 0) {
			return total - total/desconto;
		}
		
		return total;
	}
	private Double validaCupom() {
		if(this.cupom != null && "COMPRA10".equals(this.cupom.trim().toUpperCase())) {
			return 10.0;
		}
		return 0.0;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date == null ? Instant.now() : date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	public String getCupom() {
		return cupom;
	}
	public void setCupom(String cupom) {
		this.cupom = cupom;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
}
