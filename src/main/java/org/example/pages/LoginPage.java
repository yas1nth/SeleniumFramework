package org.example.pages;

import org.example.utils.CommonWebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private CommonWebDriverUtils commonWebDriverUtils;

    // Constructor — take driver from BaseTest
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.commonWebDriverUtils = new CommonWebDriverUtils(driver);
    }

    // Locators
    private By signInLink  = By.xpath("//p[contains(text(),'Sign in')]");
    private By logInWithEmailLink = By.xpath("//p[contains(text(),'Log in with Email')]");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By logInButton = By.xpath("//button[contains(text(),'Log In')]");


    // Page Actions
    public void loginAsUser(String username, String password) {
        commonWebDriverUtils.customWaitForAnElementToBeVisible(10, signInLink);
        driver.findElement(signInLink).click();
        commonWebDriverUtils.customWaitForAnElementToBeVisible(10, logInWithEmailLink);
        driver.findElement(logInWithEmailLink).click();
        commonWebDriverUtils.customWaitForAnElementToBeVisible(10, emailField);
        driver.findElement(emailField).sendKeys("yashwanthbaratam@gmail.com");
        driver.findElement(passwordField).sendKeys("Mrth@9617");
        driver.findElement(logInButton).click();
    }
}
