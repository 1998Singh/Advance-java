package com.evoke.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evoke.manytomany.entity.Tags;
 
@Repository
public interface TagsRepository  extends JpaRepository<Tags, Long>{


}
