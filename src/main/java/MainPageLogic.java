import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic extends MainPageElements {
    public SmartphonesTvAndElectronicsLogic SmartphonesTvAndElectronicsMenuClick() {
        SmartphonesTvAndElectronicsMenu.click();
        return page(SmartphonesTvAndElectronicsLogic.class);
    }
}