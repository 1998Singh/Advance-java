package com.evoke.amazon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.amazon.dto.ItemDto;
import com.evoke.amazon.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemController {

	private static final Logger log = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;

	@PostMapping("/items")
	public ResponseEntity<ItemDto> saveItems(@RequestBody ItemDto itemDto) {

		log.info("creating item {}", itemDto);
		ItemDto newItemDto = itemService.create(itemDto);

		return new ResponseEntity<ItemDto>(newItemDto, HttpStatus.CREATED);
	}

	@GetMapping("/items")
	public ResponseEntity<List<ItemDto>> getItems(ItemDto item) {

		List<ItemDto> items = itemService.getAll();

		return new ResponseEntity<List<ItemDto>>(items, HttpStatus.OK);

	}

	@GetMapping("/items/{id}")
	public ResponseEntity<ItemDto> getById(@PathVariable("id") Long id) {

		ItemDto item = itemService.getById(id);
		
		return new ResponseEntity<ItemDto>(item, HttpStatus.OK);
	}

	@PutMapping("/items/{id}")
	public ResponseEntity<ItemDto> update(@PathVariable("id") Long id, @RequestBody ItemDto itemDto) {
		
		ItemDto item = itemService.getById(id);

		item.setName(itemDto.getName());
		item.setDescription(itemDto.getDescription());
		item.setCategory(itemDto.getCategory());
		item.setColor(itemDto.getColor());
		item.setBrand(itemDto.getBrand());
		item.setQuantity(itemDto.getQuantity());
		item.setAvailableQuantity(itemDto.getAvailableQuantity());

		ItemDto updateItem = itemService.update(item);

		return ResponseEntity.ok(updateItem);

	}

	@DeleteMapping("/items/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		itemService.delete(id);
		return new ResponseEntity<String>("Item Deleted Successfully", HttpStatus.OK);
	}
}
