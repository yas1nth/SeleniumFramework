package org.example.pages;

import org.example.utils.CommonWebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage {

    private WebDriver driver;
    private CommonWebDriverUtils commonWebDriverUtils;

    // Constructor — take driver from BaseTest
    public ChatPage(WebDriver driver) {
        this.driver = driver;
        this.commonWebDriverUtils = new CommonWebDriverUtils(driver);
    }

    //Locators
    private By responseWindow = By.xpath("//div[@data-testid='virtuoso-item-list']");

    public boolean isResponseWindowVisible() {
        return driver.findElement(responseWindow).isDisplayed();
    }
}
