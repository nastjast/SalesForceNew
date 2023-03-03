package tests;

import objects.Account;
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
        Account account = new Account(accountName, "tut.by", "Description", "Analyst");
        newAccountPage.openAccountModalPage()
                .createAccount(account)
                .clickActionButton("Speichern");
        Assert.assertEquals(accountViewPage.getCreatedAccountName(), account.getAccountName());
    }

    @Test
    public void cancelAccountCreation() throws InterruptedException {
        Account account = new Account(accountName, "tut.by", "Description", "Analyst");
        newAccountPage.openAccountModalPage()
                .createAccount(account)
                .clickActionButton("Abbrechen");
        Assert.assertTrue(newAccountPage.isModalWindowDisplayed());
    }
}
