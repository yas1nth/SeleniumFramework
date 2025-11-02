import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class EmergentWebTests extends BaseTest {

    @Test
    public void verifyDashboardLoads() {
        // Example: Check if dashboard loads properly after login or landing
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Simple UI check (customize selectors based on your app)
        boolean dashboardVisible = driver.findElement(By.tagName("body")).isDisplayed();
        assert dashboardVisible : "Dashboard not visible!";
    }
}
