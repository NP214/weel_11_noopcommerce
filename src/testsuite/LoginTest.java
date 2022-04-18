package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void openBrowser() {
        setUpBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
// click on LogIn link
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
// verify the message displayed on logIn page
        // If u want to check how assert works, make expectedMsg text false..remove any thing from the below text
        String expectedMsg = "Welcome, Please Sign In!";

        // find welcome text msg on login page and get text
        WebElement actualMsg = driver.findElement(By.xpath("//div[@class='master-wrapper-content']/div/div/div/div/h1"));
        String actualMsgText = actualMsg.getText();
        System.out.println(actualMsgText);

        // validate expected text and actual text by Assert method

        Assert.assertEquals("Text not found", actualMsgText, expectedMsg);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on logIn
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("abc@gmail.com");
        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys("abc123");
        WebElement logInButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        logInButton.click();

        String logOut = driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).getText();
        System.out.println(logOut);

    }
@Test
    public void verifyTheErrorMessage() {
        //click on logIn
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("nidhiprime214@gmail.com");
        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys("Nidhi123");
        WebElement logInButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        logInButton.click();
        String expectedMsg = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        System.out.println(actualMsg);

        // validate actual result and expected result
        Assert.assertEquals("Error message not displayed", expectedMsg, actualMsg);


    }
    @After
    public void close(){
        closeBrowser();
    }

}
