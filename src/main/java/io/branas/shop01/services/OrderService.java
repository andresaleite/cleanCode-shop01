package io.branas.shop01.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.branas.shop01.dto.OrderDTO;
import io.branas.shop01.entities.Order;
import io.branas.shop01.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		if(ValidaCPF.isCpfValido(dto.getCpf())) {
			Order entity = new Order();
			entity.setCpf(dto.getCpf());
			entity.setId(dto.getId());
			entity.setProducts(dto.getProducts());
			entity.setCupom(dto.getCupom());
			entity = repository.save(entity);
			return new OrderDTO(entity);
		} else {
			return null;
		}
		
	}
	
	
}
