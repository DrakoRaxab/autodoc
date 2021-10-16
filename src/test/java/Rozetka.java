import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class Rozetka {

    @BeforeMethod
    public void before() {
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
        open("https://www.rozetka.com.ua");

    }

    @Test

    public void pageObject() throws IOException {
        new MainPageLogic().SmartphonesTvAndElectronicsMenuClick()
                .smartphonesImgClickJS()
                .selectSortClick().loadMoreCatalogItem().loadMoreCatalogItem()
                .saveTopSalesItems(SmartphonesLogic.listOfTopSalesItems)
                .writeTopSalesItemsToFile(SmartphonesLogic.listOfTopSalesItems)
                .checkSortingByPrice();
    }
}