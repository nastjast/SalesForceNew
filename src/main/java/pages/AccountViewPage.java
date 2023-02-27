package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountViewPage extends BasePage{
    public AccountViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'custom-truncate')]")
    WebElement createdAccountName;

    public String getCreatedAccountName() {
        return createdAccountName.getText();
    }
}
