package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.models.Task;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestTask {

    @Test
    public void testSetGetTaskDescription() {
        String desc = "TestTask";
        Task task = new Task();
        task.setTaskdescription(desc);
        assertEquals(desc, task.getTaskdescription());
    }

    @Test
    public void testSetGetId() {
        int id = 10;
        Task task = new Task();
        task.setId(id);
        assertEquals(id, task.getId());
    }
}
