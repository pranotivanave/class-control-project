package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	 
    @Query("SELECT a FROM Admin a WHERE a.admin_Username = :admin_Username")
    Admin findByAdmin_Username(String admin_Username);
}