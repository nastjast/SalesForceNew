package pages;

import elements.DropDownModal;
import elements.InputFieldModal;
import elements.NewAccountButtons;
import elements.TextAreaModal;
import objects.Account;
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

    public NewAccountPage createAccount(Account account) {
        new InputFieldModal(driver, "Accountname").writeText(account.getAccountName());
        new InputFieldModal(driver, "Website").writeText(account.getWebsite());
        new TextAreaModal(driver, "Beschreibung").writeText(account.getDescription());
        new DropDownModal(driver, "Typ").selectOption(account.getOption());
        return this;
    }

    public void clickActionButton(String label) {
        new NewAccountButtons(driver, label).clickButton();
    }


}
