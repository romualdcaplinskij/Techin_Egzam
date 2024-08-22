package lt.techin.calculator;

import com.github.javafaker.Faker;
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
    CalculatorMainPage calculatorMainPage;
    GenerateUserData generateUserData;

    @BeforeClass
    public void setDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofMillis(5000));
        wait = new WebDriverWait(driver, ofMillis(5000));
        driver.manage().window().maximize();
        driver.get("http://localhost:8080");
        softAssert = new SoftAssert();


        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        calculatorMainPage = new CalculatorMainPage(driver);
        generateUserData = new GenerateUserData();
    }

    @AfterClass
    public void quit(){
        //driver.quit();
    }

}
