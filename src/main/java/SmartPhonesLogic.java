import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;

public class SmartPhonesLogic extends SmartPhonesElements {
    public static ArrayList<String> listOfTopSalesItems = new ArrayList<>();

    public SmartPhonesLogic selectOfDecreasingSort() {
        selectSort.shouldBe(visible).click();
        selectSortOption.shouldBe(visible).click();
        return this;
    }

    public SmartPhonesLogic loadMoreCatalogItem(int count) {
        for (int i = 0; i < count; i++) {
            moreCatalogItems.scrollIntoView("{block: \"end\"}").click();
        }
        return this;
    }

    public SmartPhonesLogic saveTopSalesItems(ArrayList<String> list) {
        if (titleOfSalesGood.size() > 0) {
            for (int i = 0; i < titleOfSalesGood.size(); i++) {
                String lineForRecord = String.format("%s\t%s\r\n", titleOfSalesGood.get(i).getText(), priceOfSalesGood.get(i).getText());
                list.add(lineForRecord);
            }
        }
        return this;
    }

    public SmartPhonesLogic writeTopSalesItemsToFile(ArrayList<String> list) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\autodoc\\result.txt");
        for (String item : list) {
            fileWriter.write(item);
        }
        fileWriter.close();
        return this;
    }

    public SmartPhonesLogic checkSortingByPrice() {
        List<Double> pricesFromSite = new ArrayList<>();
        for (SelenideElement element : labelPrices) {
            double price = Double.parseDouble(
                    element.getText().replaceAll("\\s", ""));
            pricesFromSite.add(price);
        }
        List<Double> sortedPrices = new ArrayList(pricesFromSite);
        Collections.sort(sortedPrices);
        Collections.reverse(sortedPrices);
        Assert.assertEquals(pricesFromSite, sortedPrices);
        return this;
    }
}