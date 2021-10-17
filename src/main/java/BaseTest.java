import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {
    @BeforeMethod
    public void before() {
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }

    @AfterMethod
    private void close() {
        closeWebDriver();
    }
}