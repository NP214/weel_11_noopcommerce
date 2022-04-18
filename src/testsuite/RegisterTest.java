package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void openBrowser() {
        setUpBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //navigate to "register" and click on it
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        // expected text
        String expectedText = "Register";
        //retrieve actual text
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Register')]")).getText();
        System.out.println(actualText);
        //validate expected and actual text
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        // click on register link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();

//Select gender radio button
        driver.findElement(By.xpath("//input[@id='gender-female']")).click();
//Enter First name
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Nidhi");
//Enter Last name
       WebElement lastName= driver.findElement(By.xpath("//input[@id='LastName']"));
       lastName.sendKeys("patel");
//Select Day Month and Year
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        driver.findElement(By.xpath("//option[@value='21']")).click();
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
                driver.findElement(By.xpath("//option[contains(text(),'April')]")).click();
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        driver.findElement(By.xpath("//option[contains(text(),'1992')]")).click();
//Enter Email address
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);

        email.sendKeys("username" + randomInt + "@gmail.com");
//Enter Password
        WebElement passWord = driver.findElement(By.xpath("//input[@id='Password']"));
        passWord.sendKeys("nidhi123");
        WebElement confirmPassWord = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassWord.sendKeys("nidhi123");
        driver.findElement(By.id("register-button")).click();
        String expectedText = "Your registration completed";
        String actualText = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void quitBrowser(){
        closeBrowser();
    }

}
