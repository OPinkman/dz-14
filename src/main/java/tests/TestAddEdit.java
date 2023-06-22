package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAddEdit extends BeforeAfterTest{
    @Test
    public void testAddingAndEditingTable(){
        driver.manage().window().maximize();
        driver.get(LINK_WEBTABLE);
        getElement(ADD_ID).click();
        getElement(FIRST_NAME).sendKeys(firstName);
        getElement(LAST_NAME).sendKeys(lastName);
        getElement(EMAIL).sendKeys(email);
        getElement(AGE).sendKeys(age);
        getElement(SALARY).sendKeys(salary);
        getElement(DEPARTMENT).sendKeys(department);
        getElement(BUTTON_SUB).click();
        String userEmailText = driver.findElement(By.xpath(emailXPath)).getText();
        Assert.assertEquals(userEmailText, email, "There is no such user");
        getElement(editXPath).click();
        getElement(EMAIL).clear();
        getElement(EMAIL).sendKeys("second@mail.com");
        getElement(BUTTON_SUB).click();
        String emailAfterEditing = driver.findElement(By.xpath(secondEmailXPath)).getText();
        Assert.assertEquals(emailAfterEditing, secondMail, "There is incorrect email");
    }
}
