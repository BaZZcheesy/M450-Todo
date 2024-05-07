package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class FactRepositoryTest {
    
    @Autowired
    private FactRepository fr;

    @Test
    public void getRandomFact() {
        var res = fr.findById(4);
        assertTrue( res != null, "A fact is present");
    }
}
