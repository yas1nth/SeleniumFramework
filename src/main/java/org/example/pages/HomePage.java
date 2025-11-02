package org.example.pages;

import org.example.utils.CommonWebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private CommonWebDriverUtils commonWebDriverUtils;

    // Constructor — take driver from BaseTest
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.commonWebDriverUtils = new CommonWebDriverUtils(driver);
    }

    // Locators
    private By bannerCloseButton  = By.xpath("//div[@role='dialog']//button[@aria-label='Close modal']");
    private By homePageHeader = By.xpath("//div[contains(@class,'text-card-foreground')]//span/span");

    private By chatInputField = By.xpath("//textarea");
    private By chatSubmitButton = By.xpath("//img[@alt='Submit']/ancestor::button");
    private By toastMessageHeader = By.xpath("//div[contains(text(),'Insufficient credit balance, Please top up.')]");
    private By recentTasksSection = By.xpath("//h2[contains(text(),'Recent Tasks')]");
    private By recentTasksTable = By.xpath("(//h2[contains(text(),'Recent Tasks')]/ancestor::div[contains(@class,'flex-col ')]//table)[2]");
    private By deployedAppsSection = By.xpath("//h2[contains(text(),'Deployed Apps')]");

    private By buyCreditsButton = By.xpath("//span[text()='Buy Credits']");
    private By logoutButton = By.xpath("//div[text()='Logout']/ancestor::button");


    // Page Actions
    public void closeBannerIfPresent() {
        commonWebDriverUtils.customWaitForAnElementToBeVisible(5, bannerCloseButton);
        try {
            if (driver.findElement(bannerCloseButton).isDisplayed()) {
                driver.findElement(bannerCloseButton).click();
            }
        } catch (Exception e) {
            // Banner not present, do nothing
            System.out.println("Banner not present, skipping close action.");
        }
    }

    public String getForegroundHeaderOfHomePage(){
        return driver.findElement(homePageHeader).getText();
    }

    public boolean isSubmitButtonDisabledWhenInputEmpty() {
        WebElement input = driver.findElement(chatInputField);
        WebElement button = driver.findElement(chatSubmitButton);

        // Clear input field to ensure it's empty
        input.clear();

        // Return true if button is disabled or not clickable
        boolean isDisabled = !button.isEnabled()
                || button.getAttribute("disabled") != null
                || button.getAttribute("class").contains("disabled");

        return isDisabled;
    }

    public void enterPromptAndSubmit(String userPrompt) {
        driver.findElement(chatInputField).sendKeys(userPrompt);
        driver.findElement(chatSubmitButton).click();
    }
    public boolean isToastMessageVisible() {
        commonWebDriverUtils.customWaitForAnElementToBeVisible(1200,toastMessageHeader);
        return driver.findElement(toastMessageHeader).isDisplayed();
    }

    public boolean isRecentTasksSectionVisible() {
        commonWebDriverUtils.scrollToElement(recentTasksSection);
        return driver.findElement(recentTasksSection).isDisplayed() && driver.findElement(recentTasksTable).isDisplayed();
    }

    public boolean isDeployedAppsSectionVisible() {
        commonWebDriverUtils.scrollToElement(deployedAppsSection);
        return driver.findElement(deployedAppsSection).isDisplayed();
    }


    public void navigateToAccountSettingsSection() {
        driver.findElement(By.xpath("//button[@aria-label='Account settings']")).click();

    }

    public void navigateToBuyCredits() {
        driver.findElement(buyCreditsButton).click();
    }
}
