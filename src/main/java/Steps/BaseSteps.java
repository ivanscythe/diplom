package Steps;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Alert;

import static Pages.BasePage.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseSteps {

    public void openURLLogin() { open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); }

    public void openURLManager() { open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager"); }

    public void openURLCustomer() { open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer"); }

    public void maximizeWindow() { getWebDriver().manage().window().maximize(); }

    public void switchToAlertAndAccept() {
        Alert alert = Selenide.switchTo().alert();
        alert.accept();
    }

}
