package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CustomerPage extends BasePage {

    public static SelenideElement selectUserName = $("#userSelect");

    public static SelenideElement yourNameLabel = $(byXpath("/html/body/div/div/div[2]/div/form/div/label"));

    public static SelenideElement loginButton = $(".btn.btn-default");

    public static SelenideElement userSelectCustomer = $("#userSelect");

    public static SelenideElement logoutButton = $(".btn.logout");

    public static SelenideElement depositButton = $(byXpath("/html/body/div/div/div[2]/div/div[3]/button[2]"));

    public static SelenideElement amountInput = $(byXpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));

    public static SelenideElement depositAmountButton = $(byXpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));

    public static SelenideElement withdrawButton = $(byXpath("/html/body/div/div/div[2]/div/div[3]/button[3]"));

    public static SelenideElement withdrawInput = $(byXpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));

    public static SelenideElement withdrawAmountButton = $(byXpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
}
