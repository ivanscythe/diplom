package Steps;

import static Pages.CustomerPage.*;
import static com.codeborne.selenide.Condition.visible;

public class CustomerSteps extends BaseSteps {

    public void selectUserNameIsVisible() { selectUserName.shouldBe(visible);}

    public void selectUserName() { selectUserName.selectOption("Hermoine Granger");}

    public void yourNameLabelIsVisible() { yourNameLabel.shouldBe(visible);}

    public void loginButtonIsVisible() { loginButton.shouldBe(visible);}

    public void userSelectCustomerName() { userSelectCustomer.selectOption("Ivan Ivanov");}

    public void loginButtonClick() { loginButton.click();}

    public void logoutButtonClick() { logoutButton.click();}

    public void depositButtonClick() { depositButton.click();}

    public void amountInputSetValue() { amountInput.setValue("100");}

    public void depositAmountButtonClick() { depositAmountButton.click();}

    public void withdrawButtonClick() { withdrawButton.click();}

    public void withdrawInputSetValue100() { withdrawInput.setValue("100");}
    public void withdrawInputSetValue1111() { withdrawInput.setValue("1111");}

    public void withdrawAmountButtonClick() { withdrawAmountButton.click();}

}
