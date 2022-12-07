package com.evoke.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evoke.onlineshopping.dto.ItemDto;

public interface IteamRepository extends JpaRepository<ItemDto, Integer> {
	
	

}
