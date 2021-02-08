package com.everis.delivery.dto;

import java.util.List;

public class OrderDto {
 
	private long clientId;
	private List<ItemDto> products;
	
	public OrderDto() {
	}

	public OrderDto(long clientId, List<ItemDto> products) {
		this.clientId = clientId;
		this.products = products;
	}
	
	public Long getClientId() {
		return clientId;
	}

	public List<ItemDto> getProducts() {
		return products;
	}

	public void setProducts(List<ItemDto> products) {
		this.products = products;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (clientId ^ (clientId >>> 32));
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDto other = (OrderDto) obj;
		if (clientId != other.clientId)
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}
}