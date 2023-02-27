package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static tests.LoginTests.*;

public class AccountTests extends BaseTest {

    public String accountName = "Automation";

    @BeforeMethod
    public void loginIntoSystem() {
        loginPage.openLoginPage(URL)
                .enterCredentials(LOGIN, PASSWORD)
                .clickLoginBtn();
    }

    @Test
    public void createAccountAndCompareNameTest() {
        newAccountPage.openAccountModalPage()
                .createAccount(accountName, "hello.com", "Description")
                .clickActionButton("Speichern");
        Assert.assertEquals(accountViewPage.getCreatedAccountName(), accountName);
    }

    @Test
    public void cancelAccountCreation() throws InterruptedException {
        newAccountPage.openAccountModalPage()
                .createAccount(accountName, "hello.com", "Description")
                .clickActionButton("Abbrechen");
        Assert.assertTrue(newAccountPage.isModalWindowDisplayed());
    }
}
