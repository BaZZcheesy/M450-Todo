package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fact {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fact; // must have the EXACT name as his React state property and may not be ignored!

    public Fact() {

    }

    public int getId() {
        return id;
    }

    public String getFact() {
        return fact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
