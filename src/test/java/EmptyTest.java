import Steps.BaseSteps;
import Steps.CustomerSteps;
import Steps.MainSteps;
import Steps.ManagerSteps;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class EmptyTest {

    BaseSteps baseSteps = new BaseSteps();

    MainSteps mainSteps = new MainSteps();

    CustomerSteps customerSteps = new CustomerSteps();

    ManagerSteps managerSteps = new ManagerSteps();

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    // Main Page

    @Test
    public void allElementsVisibleMain(){
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        getWebDriver().manage().window().maximize();
        mainSteps.homeButtonIsVisible();
        mainSteps.mainHeaderIsVisible();
        mainSteps.customerLoginIsVisible();
        mainSteps.bankManagerLoginIsVisible();
    }

    @Test
    public void buttonCustomerLoginUsable() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        getWebDriver().manage().window().maximize();
        mainSteps.customerLoginButtonClick();
        customerSteps.selectUserNameIsVisible();
    }

    @Test
    public void buttonBankManagerLoginUsable() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        getWebDriver().manage().window().maximize();
        mainSteps.bankManagerLoginClick();
        managerSteps.addCustomerButtonIsVisible();
        managerSteps.openAccountButtonIsVisible();
        managerSteps.customersButtonIsVisible();
    }

    // Bank Manager Page

    @Test
    public void allElementsVisibleManager() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        getWebDriver().manage().window().maximize();
        mainSteps.homeButtonIsVisible();
        mainSteps.mainHeaderIsVisible();
        managerSteps.addCustomerButtonIsVisible();
        managerSteps.openAccountButtonIsVisible();
        managerSteps.customersButtonIsVisible();
    }

    @Test
    public void addCustomer() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        getWebDriver().manage().window().maximize();
        managerSteps.addCustomerButtonClick();
        managerSteps.firstNameInputSetValue();
        managerSteps.lastNameInputSetValue();
        managerSteps.postCodeInputSetValue();
        managerSteps.formAddCustomerButtonClick();
        Alert alert = Selenide.switchTo().alert();
        alert.accept();
        managerSteps.customersButtonClick();
        managerSteps.userFirstNameInTableIsVisible();
        managerSteps.userLastNameInTableIsVisible();
        managerSteps.userPostCodeInTableIsVisible();
    }

    @Test
    public void openCustomerAccount() {
        addCustomer();
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        managerSteps.openAccountButtonClick();
        managerSteps.userSelectDropdown();
        managerSteps.currencySelectDropdown();
        managerSteps.processButtonClick();
        Alert alert = Selenide.switchTo().alert();
        alert.accept();
        managerSteps.customersButtonClick();
        SelenideElement cell = $("table tr:nth-child(6) td:nth-child(4)");
        String cellText = cell.getText();
        if (!cellText.matches("(\\d+\\s*)+")) {
            throw new AssertionError("Cell text is not a digit: " + cellText);
        }
    }

    @Test
    public void deleteCustomerAccount() {
        addCustomer();
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        managerSteps.customersButtonClick();
        managerSteps.deleteButtonTableClick();
        managerSteps.nameInTableIsNotVisible();
    }

    @Test
    public void homeButtonManagerPage() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        getWebDriver().manage().window().maximize();
        managerSteps.homeButtonClick();
        mainSteps.customerLoginIsVisible();
        mainSteps.bankManagerLoginIsVisible();
    }


    // Customer Page

    @Test
    public void allElementsVisibleCustomerPage() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
        getWebDriver().manage().window().maximize();
        customerSteps.selectUserName();
        mainSteps.homeButtonIsVisible();
        mainSteps.mainHeaderIsVisible();
        customerSteps.yourNameLabelIsVisible();
        customerSteps.loginButtonIsVisible();
    }

    @Test
    public void customerCanLogin() {
        addCustomer();
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        mainSteps.customerLoginButtonClick();
        customerSteps.userSelectCustomerName();
        customerSteps.loginButtonClick();
        String spanText = $(".fontBig.ng-binding").getText();
        if (!spanText.matches("Ivan Ivanov")) {
            throw new AssertionError("Name is not Ivan Ivanov");
        }
    }

    @Test
    public void customerCanLogout() {
        customerCanLogin();
        customerSteps.logoutButtonClick();
        customerSteps.selectUserNameIsVisible();
    }

    @Test
    public void customerCanAddFunds() {
        openCustomerAccount();
        customerCanLogin();
        customerSteps.depositButtonClick();
        customerSteps.amountInputSetValue();
        customerSteps.depositAmountButtonClick();
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
        customerSteps.withdrawButtonClick();
        Selenide.sleep(3000);
        customerSteps.withdrawInputSetValue100();
        customerSteps.withdrawAmountButtonClick();
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
        customerSteps.withdrawButtonClick();
        Selenide.sleep(3000);
        customerSteps.withdrawInputSetValue1111();
        customerSteps.withdrawAmountButtonClick();
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
        managerSteps.homeButtonClick();
        mainSteps.customerLoginIsVisible();
        mainSteps.bankManagerLoginIsVisible();
    }
}
