import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl = "https://emergent.sh/";

    @BeforeTest
    public void setUp() {
        // Setup ChromeDriver automatically using WebDriverManager

        // Initialize the WebDriver instance
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Add implicit wait for element synchronization
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the target website
        driver.get(baseUrl);

        System.out.println("===== Browser Session Started Successfully =====");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("===== Browser Session Ended =====");
        }
    }
}
