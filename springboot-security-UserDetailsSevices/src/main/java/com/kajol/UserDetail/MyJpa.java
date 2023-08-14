package com.kajol.UserDetail;

import org.springframework.data.jpa.repository.JpaRepository;
public interface MyJpa extends JpaRepository<UserDetail, Integer> {

	UserDetail findByName(String name);
}
