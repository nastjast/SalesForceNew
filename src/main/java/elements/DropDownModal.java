package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownModal extends BaseElement{
    public DropDownModal(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String DROP_DOWN = "//*[contains(text(), '%s')]/ancestor::span[contains(@class, 'test-id__field-value')]//button";
    public static final String OPTION = "//*[contains(@class,'slds-listbox')]//span[contains(text(), '%s')]";

    public void selectOption(String option) {
        driver.findElement(By.xpath(String.format(DROP_DOWN, label))).click();
        driver.findElement(By.xpath(String.format(OPTION, option))).click();
    }
}
