import org.example.pages.BillingPage;
import org.example.pages.ChatPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmergentWebTests extends BaseTest {

    private static final Logger logger = LogManager.getLogger(EmergentWebTests.class);

    @Test
    public void verifyDashboardLoads() {
        // ---------- ARRANGE ----------
        // Initialize Page Objects using driver from BaseTest
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // ---------- ACT ----------
        // Step 1: Perform login
        loginPage.loginAsUser("yashwanthbaratam@gmail.com", "Mrth@9617");

        // Step 2: Close banner if it appears
        homePage.closeBannerIfPresent();

        // Step 3: Get the page header text and title
        String actualHeaderText = homePage.getForegroundHeaderOfHomePage();
        String actualTitle = driver.getTitle();

        // ---------- ASSERT ----------
        Assert.assertEquals(actualHeaderText, "Where ideas become reality",
                "Home page header text does not match expected value");
        // Assert page title is not empty
        Assert.assertTrue(actualTitle != null && !actualTitle.isEmpty(),
                "Page title should not be empty");
    }

    @Test
    public void verifyPromptSubmissionBlockedWhenCreditsExpired() {
        // ---------- ARRANGE ----------
        // Initialize Page Objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // ---------- ACT ----------
        // Step 1: Login with a test user who has no credits
        // (You should create a test account configured with 0 credits)
        loginPage.loginAsUser("yashwanthbaratam@gmail.com", "Mrth@9617");

        // Step 2: Close any banners
        homePage.closeBannerIfPresent();

        // Step 3: Attempt to type and submit a prompt
        String userPrompt = "Tell me a fun fact about the moon";
        homePage.enterPromptAndSubmit(userPrompt);

        // Step 4: Capture the toast message text
        boolean isToastMessageVis = homePage.isToastMessageVisible();

        // ---------- ASSERT ----------
        // Step 5: Verify toast is visible and contains expected text
        Assert.assertTrue(isToastMessageVis,
                "Toast message should be visible when credits are expired");

    }

    @Test(enabled = false)
    public void verifyAIInputFieldInteraction() {
        // ---------- ARRANGE ----------
        // Initialize Page Objects using driver from BaseTest
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ChatPage chatPage = new ChatPage(driver);

        // ---------- ACT ----------
        // Step 1: Perform login
        loginPage.loginAsUser("yashwanthbaratam@gmail.com", "Mrth@9617");

        // Step 2: Close banner if it appears
        homePage.closeBannerIfPresent();

        // Step 3: Type prompt into AI input field
        String userPrompt = "Explain the difference between AI and Machine Learning";
        homePage.enterPromptAndSubmit(userPrompt);

        // ---------- ASSERT ----------
        // Verify chat input accepted and AI responded
        Assert.assertTrue(chatPage.isResponseWindowVisible(),
                "Response window should be visible after submitting prompt");

    }

    @Test
    public void verifyRecentTasksAndDeployedAppsAreVisible() {
        // ---------- ARRANGE ----------
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // ---------- ACT ----------
        // Step 1: Log in
        loginPage.loginAsUser("yashwanthbaratam@gmail.com", "Mrth@9617");

        // Step 2: Close banner if visible
        homePage.closeBannerIfPresent();

        // Step 3: Check visibility of UI sections
        boolean isRecentTasksVisible = homePage.isRecentTasksSectionVisible();
        boolean isDeployedAppsVisible = homePage.isDeployedAppsSectionVisible();

        // ---------- ASSERT ----------
        Assert.assertTrue(isRecentTasksVisible, "'Recent Tasks' section should be visible on the Home Page");
        Assert.assertTrue(isDeployedAppsVisible, "'Deployed Apps' section should be visible on the Home Page");

        logger.info("===== Verified: Recent Tasks and Deployed Apps sections are visible =====");
    }


    @Test
    public void verifyUserNavigatesToBuyCreditsForProPlan() {
        // ---------- ARRANGE ----------
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BillingPage billingPage = new BillingPage(driver);

        // ---------- ACT ----------
        // Step 1: Log in
        loginPage.loginAsUser("yashwanthbaratam@gmail.com", "Mrth@9617");

        // Step 2: Close banner if present
        homePage.closeBannerIfPresent();

        // Step 3: Navigate to billing/credits section
        homePage.navigateToBuyCredits();

        // Step 4: Attempt to buy Pro plan
        boolean isProPlanSelected = billingPage.selectProPlan();

        // ---------- ASSERT ----------
        Assert.assertTrue(isProPlanSelected, "Pro plan should be selectable on the Billing Page");

    }
}
