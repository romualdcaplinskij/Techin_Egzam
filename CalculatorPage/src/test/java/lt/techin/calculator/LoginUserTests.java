package lt.techin.calculator;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserTests extends TestSetup{

    String errorMessage = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";

    @Test (dataProvider = "randomLoginData", dataProviderClass = CsvDataProvider.class)
    public void loginValidUser(String username, String password) throws InterruptedException {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
//        String displayedUserName = wait.until(ExpectedConditions.visibilityOf(calculatorMainPage.displayedUserName)).
//                getAccessibleName().replace("Logout, ", "");
        String displayedUserName = calculatorMainPage.getDisplayedUserName();
        //If registration is successful username should be displayed.
        Assert.assertEquals(displayedUserName, username,
                "Login was unsuccessful or username is not displayed");
    }

    @Test
    public void failingUserLogin(){
        loginPage.enterUserName("user");
        loginPage.enterPassword("");
        loginPage.clickLogin();
        String displayedUserName = calculatorMainPage.getDisplayedUserName();
        //If registration is successful username should be displayed.
        Assert.assertEquals(displayedUserName, "user",
                "Login was unsuccessful or username is not displayed");
    }

    @Test
    public void emptyUserNameField(){
        loginPage.enterUserName("");
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        //assertions checks if error message is displayed and compares message text.
        softAssert.assertFalse(loginPage.getErrorMessage().isEmpty());
        softAssert.assertEquals(errorMessage, loginPage.getErrorMessage(),
                "Error message is displayed, but not that expected");
        softAssert.assertAll();
    }
}
