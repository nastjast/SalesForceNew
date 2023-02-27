package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//ul/ancestor::*[contains(@class, 'slds-global-header__item')]")
    WebElement menuButton;

    public boolean isMenuVisible() {
        Waiters.waitForElement(driver, menuButton, 10);
        return menuButton.isDisplayed();
    }
}
