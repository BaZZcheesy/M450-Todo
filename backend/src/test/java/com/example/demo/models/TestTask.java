package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.models.Task;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestTask {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        // WebDriverManager.chromedriver().setup();
        // WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        // per Selenium documentation Opera (02.03.2023) is not supported at the moment
        // WebDriverManager.safaridriver().setup();
    }

    /**
     * Initializes the driver each time a test is executed.
     * 
     * --> Uncomment the driver for the browser you want to use.
     */
    @BeforeEach
    void setupTest() {
        // ChromeOptions options = new ChromeOptions();
    	// options.addArguments("--remote-allow-origins=*");
        // driver = new ChromeDriver();
        // driver = new EdgeDriver();
        driver = new FirefoxDriver();
        // per Selenium documentation (02.03.2023) Opera is not supported at the moment
        // driver = new SafariDriver();
    }

    /**
     * Shuts down the used browser session after every test.
     */
    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    // @Disabled("Not required after first successful test")
    public void basicTest() {
        driver.get("https://www.selenium.dev/");

        String title = driver.getTitle();

        assertEquals("Selenium", title);
    }

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
