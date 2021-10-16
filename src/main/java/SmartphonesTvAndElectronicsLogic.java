import com.codeborne.selenide.Condition;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SmartphonesTvAndElectronicsLogic extends SmartphonesTvAndElectronicsElements {
    public SmartphonesLogic smartphonesImgClickJS() {
        smartphonesImg.shouldBe(Condition.visible);
        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
        executor.executeScript("arguments[0].click();", smartphonesImg);
        return page(SmartphonesLogic.class);
    }
}