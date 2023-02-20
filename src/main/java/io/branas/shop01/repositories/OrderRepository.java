package io.branas.shop01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.branas.shop01.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	
	
}
