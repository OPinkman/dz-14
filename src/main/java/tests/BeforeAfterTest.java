package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BeforeAfterTest{
    protected int DURATION_SLEEP = 3000;
    protected String LINK_ELEMENTS = "https://demoqa.com/elements";
    protected By BUTTONS_ID = By.cssSelector("#item-4");
    protected By CLICK_ME_ID = By.xpath("//div[@class=\"mt-4\"]/button[text()=\"Click Me\"]");
    protected String MASSAGE = "#dynamicClickMessage";
    protected int DURATION = 10;
    protected WebDriver driver;
    protected String LINK_WEBTABLE = "https://demoqa.com/webtables";
    protected By ADD_ID = By.cssSelector("#addNewRecordButton");
    protected By FIRST_NAME = By.cssSelector("#firstName");
    protected By LAST_NAME = By.cssSelector("#lastName");
    protected By EMAIL = By.cssSelector("#userEmail");
    protected By AGE = By.cssSelector("#age");
    protected By SALARY = By.cssSelector("#salary");
    protected By DEPARTMENT = By.cssSelector("#department");
    protected By BUTTON_SUB = By.cssSelector("#submit");

    protected String firstName = "Petro";
    protected String lastName = "Ivasuk";
    protected String email = "ivasuk@mail.com";
    protected String secondMail = "second@mail.com";
    protected String age = "35";
    protected String salary = "5000";
    protected String department = "Agroculture";
    protected String emailXPath = String.format("//div[@class='rt-td' and @role='gridcell' and text()='%s']", email);
    protected String secondEmailXPath = String.format("//div[@class='rt-td' and @role='gridcell' and text()='%s']", secondMail);
    protected By editXPath = By.xpath("//*[contains(text(),'" + email + "')]/../div[7]/div/span[1]");

    protected WebElement getElement(final By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
