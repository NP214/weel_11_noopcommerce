package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void openBrowser() {
        setUpBrowser(baseUrl);
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("nidhiprime214@gmail.com");
        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys("Nidhi123");
        WebElement logInButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        logInButton.click();
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click on computer on topmenu
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]")).click();
        // Expected text
        String expectedText = "Computers";
        // Actual text
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]")).getText();
        System.out.println(actualText);
        // validate text
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        // clicks on Electronics
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]")).click();
        // Expected text after clicking on Electronics
        String expectedText = "Electronics";
        // inspect actual text and print
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]")).getText();
        System.out.println(actualText);
        // validate expected text and actual text
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]")).click();
        // Expected text after clicking on Apparel
        String expectedText = "Apparel";
        // inspect actual text and print
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]")).getText();
        System.out.println(actualText);
        // validate expected text and actual text
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]")).click();
        // Expected text after clicking on Digital downloads
        String expectedText = "Digital downloads";
        // inspect actual text and print
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Digital downloads')]")).getText();
        System.out.println(actualText);
        // validate expected text and actual text
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]")).click();
        // Expected text after clicking on Books
        String expectedText = "Books";
        // inspect actual text and print
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Books')]")).getText();
        System.out.println(actualText);
        // validate expected text and actual text
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]")).click();
        // Expected text after clicking on Books
        String expectedText = "Jewelry";
        // inspect actual text and print
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]")).getText();
        System.out.println(actualText);
        // validate expected text and actual text
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]")).click();
        // Expected text after clicking on Books
        String expectedText = "Gift Cards";
        // inspect actual text and print
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]")).getText();
        System.out.println(actualText);
        // validate expected text and actual text
        Assert.assertEquals(expectedText, actualText);
    }
    @After
    public void close(){
        closeBrowser();
    }
}
