package com.evoke.builderdesignpattern;

public class TestPhone {

	public static void main(String[] args) {
		
		Phone phone = new PhoneBuilder().setOs("Android").setProcessor("Qualcomm Snapdragon")
				.setRam(16).getPhone();
		
		System.out.println(phone);

	}

}
