package pages;

import elements.InputFieldModal;
import elements.NewAccountButtons;
import elements.TextAreaModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

public class NewAccountPage extends BasePage{
    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'homeMyDayHeroChart')]")
    WebElement chart;

    public boolean isModalWindowDisplayed() throws InterruptedException {
        Waiters.waitForElement(driver, chart, 5);
        return chart.isDisplayed();
    }

    public static final String URL = "https://chariteuniversitaets-medizinberli3.lightning.force.com/lightning/o/Account/new";

    public NewAccountPage openAccountModalPage() {
        openPage(URL);
        return this;
    }

    public NewAccountPage createAccount(String accountName, String website, String description) {
        new InputFieldModal(driver, "Accountname").writeText(accountName);
        new InputFieldModal(driver, "Website").writeText(website);
        new TextAreaModal(driver, "Beschreibung").writeText(description);
        return this;
    }

    public AccountViewPage clickActionButton(String label) {
        new NewAccountButtons(driver, label).clickButton();
        return new AccountViewPage(driver);
    }


}
