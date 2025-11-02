package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonWebDriverUtils {

    private WebDriver driver;
    private Actions actions;

    // Constructor — take driver from BaseTest
    public CommonWebDriverUtils(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void customWaitForAnElementToBeVisible(int timeInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void scrollToElement(By locator) {
        actions.moveToElement(driver.findElement(locator)).perform();
    }
}
