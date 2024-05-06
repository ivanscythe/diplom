package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ManagerPage extends BasePage {

    public static SelenideElement addCustomerButton = $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[1]"));

    public static SelenideElement openAccountButton = $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[2]"));

    public static SelenideElement customersButton = $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[3]"));

    public static SelenideElement firstNameInput = $(byXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input"));

    public static SelenideElement lastNameInput = $(byXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input"));

    public static SelenideElement postCodeInput = $(byXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input"));

    public static SelenideElement formAddCustomerButton = $(byXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));

    public static SelenideElement userFirstNameInTable = $(byText("Ivan"));

    public static SelenideElement userLastNameInTable = $(byText("Ivanov"));

    public static SelenideElement userPostCodeInTable = $(byText("123"));

    public static SelenideElement userSelect = $("#userSelect");

    public static SelenideElement currencySelect = $("#currency");

    public static SelenideElement processButton = $(byText("Process"));

    public static SelenideElement deleteButtonInTable = $(byXpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[5]/button"));

    public static SelenideElement nameInTable = $(byText("Ivan"));

    public static SelenideElement homeButton = $(".btn.home");
}
