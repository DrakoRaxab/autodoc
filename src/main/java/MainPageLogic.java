import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic extends MainPageElements {
    public SmartPhonesTvAndElectronicsLogic selectSmartPhonesTvAndElectronics() {
        smartPhonesTvAndElectronicsMenu.click();
        return page(SmartPhonesTvAndElectronicsLogic.class);
    }
}