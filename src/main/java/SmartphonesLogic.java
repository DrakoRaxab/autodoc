import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static com.codeborne.selenide.Condition.*;

public class SmartphonesLogic extends SmartphonesElements {
    public static ArrayList<String> listOfTopSalesItems = new ArrayList<>();

    public SmartphonesLogic selectSortClick() {
        selectSort.shouldBe(visible).click();
        selectSortOption.shouldBe(visible).click();
        return this;
    }

    public SmartphonesLogic loadMoreCatalogItem() {
        moreCatalogItems.scrollIntoView("{block: \"end\"}").click();
        return this;
    }

    public SmartphonesLogic saveTopSalesItems(ArrayList<String> list) {
        if (titleOfSalesGood.size() > 0) {
            for (int i = 0; i < titleOfSalesGood.size(); i++) {
                String lineForRecord = String.format("%s\t%s\r\n", titleOfSalesGood.get(i).getText(), priceOfSalesGood.get(i).getText());
                list.add(lineForRecord);
            }
        }
        return this;
    }

    public SmartphonesLogic writeTopSalesItemsToFile(ArrayList<String> list) throws IOException {
        FileWriter filewriter = new FileWriter("C:\\Autodoc\\result.txt");
        for (String item : list) {
            filewriter.write(item); // Записываем все елементы листа в файл
        }
        filewriter.close();
        return this;
    }

    public SmartphonesLogic checkSortingByPrice() {
        List<Double> pricesFromSite = new ArrayList<>();

        for (SelenideElement element : labelPrices) {
//            String price = element.text();
            double price = Double.parseDouble(
                    element.getText().replaceAll("\\s+", ""));
            pricesFromSite.add(price);
        }
        //делаем копию списка pricesFromSite и сортируем список sortedPrices
        List<Double> sortedPrices = new ArrayList(pricesFromSite);

        Collections.sort(sortedPrices);  //по возростанию
        Collections.reverse(sortedPrices); //по убыванию
        Assert.assertEquals(pricesFromSite, sortedPrices);

        return this;
    }
}