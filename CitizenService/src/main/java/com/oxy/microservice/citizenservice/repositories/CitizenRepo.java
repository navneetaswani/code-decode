package com.oxy.microservice.citizenservice.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oxy.microservice.citizenservice.dto.Citizen;



public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
	
	public List<Citizen> findByVaccinationCenterId(Integer id);

}
