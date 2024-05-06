package Steps;

import static Pages.MainPage.*;
import static com.codeborne.selenide.Condition.visible;

public class MainSteps extends BaseSteps {
    public void homeButtonIsVisible() {
        homeButton.shouldBe(visible);
    }
    public void mainHeaderIsVisible() { mainHeader.shouldBe(visible);}

    public void customerLoginIsVisible() { customerLogin.shouldBe(visible);}

    public void bankManagerLoginIsVisible() { bankManagerLogin.shouldBe(visible);}

    public void customerLoginButtonClick() { customerLogin.click(); }

    public void bankManagerLoginClick() { bankManagerLogin.click(); }
}
