package com.evoke.onlineshopping.service;

import java.util.List;

import com.evoke.onlineshopping.dto.ItemDto;

public interface ItemService {
	
	public List<ItemDto> getAllItems();
	
	public void saveItem(ItemDto itemdto);
	
	public ItemDto getById(Integer id);
	
	public void deleteById(Integer id);

}
