package lt.techin.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import static java.time.Duration.*;

public class TestSetup {

    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert;

    LoginPage loginPage;
    RegisterPage registerPage;
    LoggedUserPage loggedUserPage;

    @BeforeClass
    public void setDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofMillis(2000));
        wait = new WebDriverWait(driver, ofMillis(2000));
        driver.manage().window().maximize();
        driver.get("http://localhost:8080");
        softAssert = new SoftAssert();

        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        loggedUserPage = new LoggedUserPage(driver);
    }

    @AfterClass
    public void quit(){
        //driver.quit();
    }

}
