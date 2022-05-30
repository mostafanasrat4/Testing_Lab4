import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {

    static WebDriver edgeDriver;
    static final String Website = "https://formy-project.herokuapp.com/form";

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.edgedriver().setup();
        edgeDriver = new EdgeDriver();
        edgeDriver.get(Website);
    }

    @Test
    public void firstNameTest(){
        WebElement firstNameText = edgeDriver.findElement(By.id("first-name"));
        firstNameText.sendKeys("Mostafa");
        assertEquals("Mostafa", firstNameText.getAttribute("value"));
    }
    @Test
    public void lastNameTest(){
        WebElement lastNameText = edgeDriver.findElement(By.id("last-name"));
        lastNameText.sendKeys("Nasrat");
        assertEquals("Nasrat", lastNameText.getAttribute("value"));
    }

    @Test
    public void jobTitleTest(){
        WebElement jobTitleText = edgeDriver.findElement(By.id("job-title"));
        jobTitleText.sendKeys("Junior Student");
        assertEquals("Junior Student",jobTitleText.getAttribute("value"));
    }

    @Test
    public void educationLevelTest(){
        WebElement collegeRadio = edgeDriver.findElement(By.id("radio-button-2"));
        collegeRadio.click();
        assertTrue(collegeRadio.isSelected());
    }

    @Test
    public void sexTest(){
        WebElement maleCheckbox = edgeDriver.findElement(By.id("checkbox-1"));
        WebElement femaleCheckbox = edgeDriver.findElement(By.id("checkbox-2"));
        WebElement preferNotToSayCheckbox = edgeDriver.findElement(By.id("checkbox-3"));
        maleCheckbox.click();
        assertTrue(maleCheckbox.isSelected());
        assertFalse(femaleCheckbox.isSelected());
        assertFalse(preferNotToSayCheckbox.isSelected());
    }

    @AfterAll
    public static void afterAll(){
        WebElement submitButton = edgeDriver.findElement(By.className("btn"));
        submitButton.click();
    }
}
