package com.example.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Fact;
import com.example.repository.FactRepository;

@RestController
// @CrossOrigin( origins = "http://localhost:3000/")
@RequestMapping("/random")
public class RandomController {

    @Autowired
    private FactRepository fr;

    @GetMapping("/{number}")
    public String getRandomFact(@PathVariable( value = "number") int number) {
        try {
            var oFact = fr.findById(number);
            if (oFact.isPresent()) {
                return oFact.get().getFact();
            }
            return "We couldnt find a fact with that ID";
        }
        catch (Exception ex) {
            System.out.println(ex);
            return "Something went wrong";
        }
    }
}