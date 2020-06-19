package com.example.BootJPA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.BootJPA.model.Engineer;

public interface EngineerRepo extends JpaRepository<Engineer, Integer> {

	@Query("from Engineer where eLang=?1 order by eName desc")
	List<Engineer> findByeLang(String eLang);

}
