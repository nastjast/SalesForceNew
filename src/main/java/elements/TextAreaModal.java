package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextAreaModal extends BaseElement{
    public TextAreaModal(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String TEXT_AREA_MODAL = "//*[contains(text(), '%s')]/ancestor::*[@slot='input']//textarea";

    public void writeText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(TEXT_AREA_MODAL, label)))));
        driver.findElement(By.xpath(String.format(TEXT_AREA_MODAL, label))).sendKeys(text);
    }
}
