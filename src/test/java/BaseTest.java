import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl = "https://emergent.sh/";

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver instance
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Implicit wait for element synchronization
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the target site
        driver.get(baseUrl);

        System.out.println("===== Browser Session Started Successfully =====");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // Quit browser after each test — runs even if test fails or throws exception
        if (driver != null) {
            driver.quit();
            System.out.println("===== Browser Session Ended =====");
        }
    }
}
