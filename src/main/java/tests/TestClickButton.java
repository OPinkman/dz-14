package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClickButton extends BeforeAfterTest{
    @Test
    public void testClickButton(){
        driver.get(LINK_ELEMENTS);
        getElement(BUTTONS_ID).click();
        getElement(CLICK_ME_ID).click();
        try {
            Thread.sleep(DURATION_SLEEP);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String massageText = driver.findElement(By.cssSelector(MASSAGE)).getText();
        System.out.println(massageText);
        Assert.assertEquals(massageText, "You have done a dynamic click", "There is no such text there");
    }
}
