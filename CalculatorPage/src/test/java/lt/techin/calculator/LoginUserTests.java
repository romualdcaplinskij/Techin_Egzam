package lt.techin.calculator;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserTests extends TestSetup{

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
}
