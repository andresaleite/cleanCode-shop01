package io.branas.shop01.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.branas.shop01.dto.OrderDTO;
import io.branas.shop01.entities.Product;
import io.branas.shop01.tests.Factory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class OrderControllerIT {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	public void insertShouldInsertNoCupomResource() throws Exception {
		
		Set<Product> products = new HashSet<Product>();
		products.add(Factory.createProduct());
		products.add(Factory.createProduct1());
		products.add(Factory.createProduct2());
		
		OrderDTO dto = Factory.createOrderDTO(Factory.createOrder(products,""));
		String jsonBody = objectMapper.writeValueAsString(dto);
		
		ResultActions result =
				mockMvc.perform(post("/orders")
						.content(jsonBody)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(status().isCreated());
		assertEquals(914, dto.getTotal());
	}	
	@Test
	public void insertShouldInsertWithCupomResource() throws Exception {
		
		Set<Product> products = new HashSet<Product>();
		products.add(Factory.createProduct());
		products.add(Factory.createProduct1());
		products.add(Factory.createProduct2());
		
		OrderDTO dto = Factory.createOrderDTO(Factory.createOrder(products, "COMPRA10"));
		String jsonBody = objectMapper.writeValueAsString(dto);
		
		ResultActions result =
				mockMvc.perform(post("/orders")
						.content(jsonBody)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.cupom").value("COMPRA10"));
		assertEquals(822.6, dto.getTotal());
	}	
	@Test
	public void insertShouldInsertWithCPFInvalido() throws Exception {
		Set<Product> products = new HashSet<Product>();
		products.add(Factory.createProduct());
		products.add(Factory.createProduct1());
		products.add(Factory.createProduct2());
		
		OrderDTO dto = Factory.createOrderDTO(Factory.createOrder(products, "COMPRA10"));
		dto.setCpf("99999999-11");
		String jsonBody = objectMapper.writeValueAsString(dto);
		
		ResultActions result =
				mockMvc.perform(post("/orders")
						.content(jsonBody)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isBadRequest());
	}	
	@Test
	public void insertShouldInsertSemProdutos() throws Exception {
		Set<Product> products = new HashSet<Product>();
		OrderDTO dto = Factory.createOrderDTO(Factory.createOrder(products, "COMPRA10"));
		dto.setCpf("99999999-11");
		String jsonBody = objectMapper.writeValueAsString(dto);
		
		ResultActions result =
				mockMvc.perform(post("/orders")
					.content(jsonBody)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isBadRequest());
	}	
}
