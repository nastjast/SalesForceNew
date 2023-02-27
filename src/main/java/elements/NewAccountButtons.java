package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountButtons extends BaseElement{
    public NewAccountButtons(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String CREATE_ACCOUNT_BUTTON = "//*[contains(@class, 'slds-button-group-row')]//button[text()= '%s']";

    public void clickButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(CREATE_ACCOUNT_BUTTON, label)))));
        driver.findElement(By.xpath(String.format(CREATE_ACCOUNT_BUTTON, label))).click();
    }
}
