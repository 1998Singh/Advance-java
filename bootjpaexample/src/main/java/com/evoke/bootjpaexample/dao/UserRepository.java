package com.evoke.bootjpaexample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evoke.bootjpaexample.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
