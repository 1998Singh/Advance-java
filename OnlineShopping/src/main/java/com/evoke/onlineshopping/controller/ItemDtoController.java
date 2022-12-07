package com.evoke.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.onlineshopping.dto.ItemDto;
import com.evoke.onlineshopping.service.ItemService;

@RestController
public class ItemDtoController {

	@Autowired
	private ItemService itemservice;

	@GetMapping("/api/allitems")
	public List<ItemDto> gettingAllDetails() {
		return itemservice.getAllItems();
	}

	@GetMapping("/api/getitem/{id}")
	public ItemDto getById(@PathVariable(value = "id") Integer id) {
		ItemDto iteamdto = itemservice.getById(id);
		return iteamdto;
	}

	@PostMapping("/api/items")
	public ResponseEntity<String> addIteam(@RequestBody ItemDto iteamdto) {
		itemservice.saveItem(iteamdto);
		return new ResponseEntity<String>("Iteam added Successfully", HttpStatus.CREATED);
	}
      
	@DeleteMapping("/api/deleteitem/{id}")
	public String deleteById(@PathVariable(value = "id") Integer id) {
		itemservice.deleteById(id);
		return "Deleted Successfully";

	}

}
