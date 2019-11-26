package com.rios.tacocloud;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class JdbcTacoOrderRepository implements OrderRepository {
	
	private SimpleJdbcInsert orderInserter;
	private SimpleJdbcInsert orderTacoInserter;
	private ObjectMapper objectMapper;
	
	@Autowired
	public JdbcTacoOrderRepository(JdbcTemplate jdbc) {
		this.orderInserter = new SimpleJdbcInsert(jdbc)
				.withTableName("Taco_Order")
				.usingGeneratedKeyColumns("id");
		
		this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
				.withTableName("Taco_Order_Tacos");
		
		this.objectMapper = new ObjectMapper();
	}
	
	@Override
	public TacoOrder save(TacoOrder tacoOrder) {
		tacoOrder.setPlacedAt(new Date());
		long orderId = saveOrderDetails(tacoOrder);
		tacoOrder.setId(orderId);
		List<Taco> tacos = tacoOrder.getTacos();
		for (Taco taco : tacos) {
			saveTacoToOrder(taco, orderId);
		}
		return tacoOrder;
	}
	
	private long saveOrderDetails(TacoOrder tacoOrder) {
		@SuppressWarnings("unchecked")
		Map<String, Object> values = objectMapper.convertValue(tacoOrder, Map.class);
		values.put("placedAt", tacoOrder.getPlacedAt());
		
		long orderId = orderInserter
				.executeAndReturnKey(values)
				.longValue();
		return orderId;
	}
	
	private void saveTacoToOrder(Taco taco, long orderId) {
		Map<String, Object> values = new HashMap<>();
		values.put("tacoOrder", orderId);
		values.put("taco", taco.getId());
		orderTacoInserter.execute(values);
	}

}
