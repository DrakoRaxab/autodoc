import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SmartPhonesTvAndElectronicsLogic extends SmartPhonesTvAndElectronicsElements {
    public SmartPhonesLogic selectSmartPhoneCategory() {
        smartPhonesImg.shouldBe(visible);
        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
        executor.executeScript("arguments[0].click();", smartPhonesImg);
        return page(SmartPhonesLogic.class);
    }
}