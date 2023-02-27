package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountViewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    NewAccountPage newAccountPage;
    AccountViewPage accountViewPage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        newAccountPage = new NewAccountPage(driver);
        accountViewPage = new AccountViewPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }


    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }


}
