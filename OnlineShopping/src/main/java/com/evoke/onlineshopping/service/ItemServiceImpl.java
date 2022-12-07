package com.evoke.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoke.onlineshopping.dto.ItemDto;
import com.evoke.onlineshopping.repository.IteamRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private IteamRepository itemRepo;

	@Override
	public List<ItemDto> getAllItems() {

		return itemRepo.findAll();
	}

	@Override
	public void saveItem(ItemDto itemdto) {

		itemRepo.save(itemdto);

	}

	@Override
	public ItemDto getById(Integer id) {
		Optional<ItemDto>optional = itemRepo.findById(id);
		ItemDto itemdto=null;
		if(optional.isPresent())
			itemdto=optional.get();
		else
			throw new RuntimeException("Product not found for id"+id);
		return itemdto;
			
	}

	@Override
	public void deleteById(Integer id) {
		
		itemRepo.deleteById(id);
		
	}

}
