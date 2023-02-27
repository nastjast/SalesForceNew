package pages;

import elements.InputFieldLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Login")
    WebElement loginBtn;

    @FindBy(id = "error")
    WebElement errorMsg;

    public String getErrorText() {
        return errorMsg.getText();
    }

    public LoginPage openLoginPage(String url) {
        openPage(url);
        return this;
    }

    public LoginPage enterCredentials(String username, String password) {
        new InputFieldLogin(driver, "username").sendCredentials(username);
        new InputFieldLogin(driver, "password").sendCredentials(password);
        return this;
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
