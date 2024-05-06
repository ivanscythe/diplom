package Steps;

import static Pages.ManagerPage.*;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;

public class ManagerSteps extends BaseSteps {

    public void addCustomerButtonIsVisible() { addCustomerButton.shouldBe(visible);}

    public void openAccountButtonIsVisible() { openAccountButton.shouldBe(visible);}

    public void customersButtonIsVisible() { customersButton.shouldBe(visible);}

    public void addCustomerButtonClick() { addCustomerButton.click();}

    public void firstNameInputSetValue() { firstNameInput.setValue("Ivan");}

    public void lastNameInputSetValue() { lastNameInput.setValue("Ivanov");}

    public void postCodeInputSetValue() { postCodeInput.setValue("123");}

    public void formAddCustomerButtonClick() { formAddCustomerButton.click();}

    public void customersButtonClick() {customersButton.click();}

    public void userFirstNameInTableIsVisible() { userFirstNameInTable.shouldBe(visible);}

    public void userLastNameInTableIsVisible() { userLastNameInTable.shouldBe(visible);}

    public void userPostCodeInTableIsVisible() { userPostCodeInTable.shouldBe(visible);}

    public void openAccountButtonClick() { openAccountButton.click();}

    public void userSelectDropdown() { userSelect.selectOption("Ivan Ivanov");}

    public void currencySelectDropdown() { currencySelect.selectOption("Dollar");}

    public void processButtonClick() { processButton.click();}

    public void deleteButtonTableClick() { deleteButtonInTable.click();}

    public void nameInTableIsNotVisible() { nameInTable.shouldBe(not(visible));}

    public void homeButtonClick() { homeButton.click();}
}
