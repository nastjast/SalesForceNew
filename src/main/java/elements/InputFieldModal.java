package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputFieldModal extends BaseElement{

    public InputFieldModal(WebDriver driver, String label) {
        super(driver, label);
    }
    private static final String INPUT = "//*[contains(text(), '%s')]/ancestor::div[contains(@part, 'input-text')]//input";

    public void writeText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(INPUT, label)))));
        driver.findElement(By.xpath(String.format(INPUT, label))).sendKeys(text);
    }
}
