package com.evoke.onlineshopping.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PriceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double price;
	private int discount;

	public PriceDto() {
		super();

	}

	public PriceDto(int id, double price, int discount) {
		super();
		this.id = id;
		this.price = price;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
