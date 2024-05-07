package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Fact;

public interface FactRepository extends JpaRepository<Fact, Integer>{

}
