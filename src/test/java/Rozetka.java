import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class Rozetka extends BaseTest {
    @Test
    public void checkRozetka() throws IOException {
        open("https://www.rozetka.com.ua");
        new MainPageLogic().selectSmartPhonesTvAndElectronics()
                .selectSmartPhoneCategory()
                .selectOfDecreasingSort()
                .loadMoreCatalogItem(2)
                .saveTopSalesItems(SmartPhonesLogic.listOfTopSalesItems)
                .writeTopSalesItemsToFile(SmartPhonesLogic.listOfTopSalesItems)
                .checkSortingByPrice();
    }
}