package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MathQuestionServiceSeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/nipunathathasara/Downloads/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLogin() {
        driver.get("http://localhost:8080/login");
        sleep(5);

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement dobInput = driver.findElement(By.id("dob"));
        WebElement submitButton = driver.findElement(By.id("loginButton"));

        assertNotNull(usernameInput);
        assertNotNull(passwordInput);
        assertNotNull(dobInput);
        assertNotNull(submitButton);

        usernameInput.sendKeys("nipuna");
        passwordInput.sendKeys("nipuna_pass");
        dobInput.sendKeys("1999-05-29");
        submitButton.click();

        sleep(5);

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/q1", currentUrl);
    }

    @Test
    public void testQ1Addition() {
        driver.get("http://localhost:8080/q1");
        sleep(5);

        WebElement number1Input = driver.findElement(By.id("number1"));
        WebElement number2Input = driver.findElement(By.id("number2"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));

        assertNotNull(number1Input);
        assertNotNull(number2Input);
        assertNotNull(submitButton);

        number1Input.sendKeys("5");
        number2Input.sendKeys("7");
        submitButton.click();

        sleep(5);

        WebElement messageElement = driver.findElement(By.xpath("//div[@id='message']"));
        String message = messageElement.getText();
        assertEquals("Correct answer!", message);
    }

    @Test
    public void testQ2Subtraction() {
        driver.get("http://localhost:8080/q2");
        sleep(5);

        WebElement number1Input = driver.findElement(By.id("number1"));
        WebElement number2Input = driver.findElement(By.id("number2"));
        WebElement resultInput = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));

        assertNotNull(number1Input);
        assertNotNull(number2Input);
        assertNotNull(resultInput);
        assertNotNull(submitButton);

        number1Input.sendKeys("10");
        number2Input.sendKeys("3");
        resultInput.sendKeys("7");
        submitButton.click();

        sleep(5);

        WebElement messageElement = driver.findElement(By.xpath("//div[@id='message']"));
        String message = messageElement.getText();
        assertEquals("Correct answer!", message);
    }

    @Test
    public void testQ3Multiplication() {
        driver.get("http://localhost:8080/q3");
        sleep(5);

        WebElement number1Input = driver.findElement(By.id("number1"));
        WebElement number2Input = driver.findElement(By.id("number2"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));

        assertNotNull(number1Input);
        assertNotNull(number2Input);
        assertNotNull(submitButton);

        number1Input.sendKeys("4");
        number2Input.sendKeys("6");
        submitButton.click();

        sleep(5);

        WebElement messageElement = driver.findElement(By.xpath("//div[@id='message']"));
        String message = messageElement.getText();
        assertEquals("Correct answer!", message);
    }
}
