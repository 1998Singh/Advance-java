package com.evoke.constructorspring;

//Dependency Injection by  Constructor.

public class Laptops {

	private String brandname;
	private int price;

	public Laptops() {

		System.out.println("Default construcror");

	}

	public Laptops(String brandname) {
		super();
		this.brandname = brandname;
	}

	public Laptops(String brandname, int price) {
		super();
		this.brandname = brandname;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Laptops [brandname=" + brandname + ", price=" + price + "]";
	}

}
