package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    public static final String URL = "https://chariteuniversitaets-medizinberli3.my.salesforce.com/";
    public static final String LOGIN = "ananastasja1-lg4g@force.com";
    public static final String PASSWORD = "Matveeva1995!";
    public static final String INVALID_LOGIN = "123";
    public static final String INVALID_PASSWORD = "456";
    public static final String ERROR_TEXT = "Please check your username and password";
    public static final String MISSING_PASSWORD = "Please enter your password.";


    @Test
    public void loginWithValidCredsTest() {
        loginPage.openLoginPage(URL)
                .enterCredentials(LOGIN, PASSWORD)
                .clickLoginBtn();
        Assert.assertTrue(homePage.isMenuVisible());
    }

    @Test
    public void loginWithInvalidCredsTest() {
        loginPage.openLoginPage(URL)
                .enterCredentials(INVALID_LOGIN, INVALID_PASSWORD)
                .clickLoginBtn();
        Assert.assertTrue(loginPage.getErrorText().contains(ERROR_TEXT));
    }

    @Test
    public void loginWithoutPasswordTest() {
        loginPage.openLoginPage(URL)
                .enterCredentials(INVALID_LOGIN, "")
                .clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorText(), MISSING_PASSWORD);
    }
}
