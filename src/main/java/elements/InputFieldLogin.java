package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputFieldLogin extends BaseElement{
    public InputFieldLogin(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String INPUT_LOGIN = "//input[contains(@id, '%s')]";

    public void sendCredentials(String creds) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(INPUT_LOGIN, label)))));
        driver.findElement(By.xpath(String.format(INPUT_LOGIN, label))).sendKeys(creds);
    }
}
