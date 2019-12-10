package webdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.seljup.SeleniumExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
public class HelloServletFunctionalTest {

    @Test
    public void sayHello(ChromeDriver driver) throws Exception {      
        driver.get("http://localhost:8080/webdemo");

        driver.findElement(By.id("say-hello-text-input")).sendKeys("Dolly");
        driver.findElement(By.id("say-hello-button")).click();

        assertEquals("Hello Page", driver.getTitle());
        assertEquals("Hello, Dolly!", driver.findElement(By.tagName("h2")).getText());
    }
}