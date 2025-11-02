package org.example.pages;

import org.example.utils.CommonWebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingPage {

    private WebDriver driver;
    private CommonWebDriverUtils commonWebDriverUtils;

    //locators
    private By proPlanSelectButton = By.xpath("//button[text()='Upgrade to Pro']");

    // Constructor — take driver from BaseTest
    public BillingPage(WebDriver driver) {
        this.driver = driver;
        this.commonWebDriverUtils = new CommonWebDriverUtils(driver);
    }

    public boolean selectProPlan() {
        driver.findElement(proPlanSelectButton).click();
        return true;
    }

}
