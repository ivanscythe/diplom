import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class EmptyTest {

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    // Main Page

    @Test
    public void allElementsVisibleMain(){
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        getWebDriver().manage().window().maximize();
        $(".btn.home").shouldBe(visible);
        $(".mainHeading").shouldBe(visible);
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).shouldBe(visible); // Customer Login
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")).shouldBe(visible); // Bank Manager Login
    }

    @Test
    public void buttonCustomerLoginUsable() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        getWebDriver().manage().window().maximize();
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
        $("#userSelect").shouldBe(visible);
    }

    @Test
    public void buttonBankManagerLoginUsable() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        getWebDriver().manage().window().maximize();
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")).click();
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).shouldBe(visible); // add customer
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).shouldBe(visible); // open account
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).shouldBe(visible); // customers
    }

    // Bank Manager Page

    @Test
    public void allElementsVisibleManager() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        getWebDriver().manage().window().maximize();
        $(".btn.home").shouldBe(visible);
        $(".mainHeading").shouldBe(visible);
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).shouldBe(visible); // add customer
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).shouldBe(visible); // open account
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).shouldBe(visible); // customers
    }

    @Test
    public void addCustomer() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        getWebDriver().manage().window().maximize();
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).click();
        $(byXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).setValue("Ivan");
        $(byXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).setValue("Ivanov");
        $(byXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).setValue("123");
        $(byXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
        Alert alert = Selenide.switchTo().alert();
        alert.accept();
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
        $(byText("Ivan")).shouldBe(visible);
        $(byText("Ivanov")).shouldBe(visible);
        $(byText("123")).shouldBe(visible);
    }

    @Test
    public void openCustomerAccount() {
        addCustomer();
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
        $("#userSelect").selectOption("Ivan Ivanov");
        $("#currency").selectOption("Dollar");
        $(byText("Process")).click();
        Alert alert = Selenide.switchTo().alert();
        alert.accept();
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
        SelenideElement cell = $("table tr:nth-child(6) td:nth-child(4)");
        String cellText = cell.getText();
        if (!cellText.matches("\\d+")) {
            throw new AssertionError("Cell text is not a digit: " + cellText);
        }
    }

    @Test
    public void deleteCustomerAccount() {
        addCustomer();
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
        $(byXpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[5]/button")).click();
        $(byText("Ivan")).shouldBe(not(visible));
    }

    @Test
    public void homeButtonManagerPage() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        getWebDriver().manage().window().maximize();
        $(".btn.home").click();
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).shouldBe(visible);
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")).shouldBe(visible);
    }


    // Customer Page

    @Test
    public void allElementsVisibleCustomerPage() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
        getWebDriver().manage().window().maximize();
        $("#userSelect").selectOption("Hermoine Granger");
        $(".btn.home").shouldBe(visible);
        $(".mainHeading").shouldBe(visible);
        $(byXpath("/html/body/div/div/div[2]/div/form/div/label")).shouldBe(visible); // Your Name label
        $(".btn.btn-default").shouldBe(visible);
    }

    @Test
    public void customerCanLogin() {
        addCustomer();
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
        $("#userSelect").selectOption("Ivan Ivanov");
        $(".btn.btn-default").click();
        String spanText = $(".fontBig.ng-binding").getText();
        if (!spanText.matches("Ivan Ivanov")) {
            throw new AssertionError("Name is not Ivan Ivanov");
        }
    }

    @Test
    public void customerCanLogout() {
        customerCanLogin();
        $(".btn.logout").click();
        $("#userSelect").shouldBe(visible);
    }

    @Test
    public void customerCanAddFunds() {
        openCustomerAccount();
        customerCanLogin();
        $(byXpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
        $(byXpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).setValue("100");
        $(byXpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
        String depositText = $(".error.ng-binding").getText();
        if (!depositText.matches("Deposit Successful")) {
            throw new AssertionError("deposit unsuccessful");
        }
        String balanceSum = $(byXpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
        if (!balanceSum.matches("100")) {
            throw new AssertionError("balance is not 100");
        }
    }

    @Test
    public void customerCanWithdrawFunds() {
        customerCanAddFunds();
        $(byXpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();
        Selenide.sleep(3000);
        $(byXpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).setValue("100");
        $(byXpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
        String withdrawText = $(".error.ng-binding").getText();
        if (!withdrawText.matches("Transaction successful")) {
            throw new AssertionError("transaction unsuccessful");
        }
        String balanceSum = $(byXpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
        if (!balanceSum.matches("0")) {
            throw new AssertionError("balance is not 0");
        }
    }

    @Test
    public void cannotWithdrawMoreThanHave() {
        customerCanAddFunds();
        $(byXpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();
        Selenide.sleep(3000);
        $(byXpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).setValue("1111");
        $(byXpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
        String withdrawText = $(".error.ng-binding").getText();
        if (!withdrawText.matches("Transaction Failed. You can not withdraw amount more than the balance.")) {
            throw new AssertionError("fail");
        }
        String balanceSum = $(byXpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
        if (!balanceSum.matches("100")) {
            throw new AssertionError("balance is not 100");
        }
    }

    @Test
    public void homeButtonCustomerPage() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
        $(".btn.home").click();
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).shouldBe(visible);
        $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")).shouldBe(visible);
    }
}
