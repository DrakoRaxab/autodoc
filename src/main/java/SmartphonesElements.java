import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SmartphonesElements {
    SelenideElement selectSort = $(By.tagName("select"));
    SelenideElement selectSortOption = $(By.xpath("//option[contains(text(),'От дорогих к дешевым')]"));
    SelenideElement moreCatalogItems = $(By.xpath("//span[@class='show-more__text']"));
    ElementsCollection labelPrices = $$(By.xpath("//span[@class='goods-tile__price-value']"));
    ElementsCollection titleOfSalesGood = $$(By.xpath("//span[contains(text(),'Акция')]/ancestor::div[@class='goods-tile ng-star-inserted']//a/span[@class='goods-tile__title']"));
    ElementsCollection priceOfSalesGood = $$(By.xpath("//span[contains(text(),'Акция')]/ancestor::div[@class='goods-tile ng-star-inserted']//div[@class='goods-tile__prices']/div[2]/p/span[@class='goods-tile__price-value']"));

}