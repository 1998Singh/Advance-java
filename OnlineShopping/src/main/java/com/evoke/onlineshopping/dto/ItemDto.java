package com.evoke.onlineshopping.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ItemDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column
	private String name;
    @Column
	private String description;
    @Column
	private String category;
    @Column
	private String status;

	public ItemDto() {
		super();
		
	}

	public ItemDto(int id, String name, String description, String category, String status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "IteamDto [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", status=" + status + "]";
	}

}
