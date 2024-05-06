package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage{

    public static SelenideElement homeButton = $(".btn.home");

    public static SelenideElement mainHeader = $(".mainHeading");

    public static SelenideElement customerLogin = $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button"));

    public static SelenideElement bankManagerLogin = $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button"));


}
